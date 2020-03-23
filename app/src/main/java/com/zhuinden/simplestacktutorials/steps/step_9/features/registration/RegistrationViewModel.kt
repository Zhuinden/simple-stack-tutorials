package com.zhuinden.simplestacktutorials.steps.step_9.features.registration

import android.content.Context
import com.jakewharton.rxrelay2.BehaviorRelay
import com.zhuinden.rxcombinetuplekt.combineTuple
import com.zhuinden.simplestack.*
import com.zhuinden.simplestacktutorials.steps.step_9.AuthenticationManager
import com.zhuinden.simplestacktutorials.steps.step_9.features.profile.ProfileKey
import com.zhuinden.statebundle.StateBundle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class RegistrationViewModel(
    private val appContext: Context,
    private val backstack: Backstack
) : Bundleable, ScopedServices.Registered, ScopedServices.HandlesBack {
    enum class RegistrationState { // this is actually kinda superfluous/unnecessary but ok
        COLLECT_PROFILE_DATA,
        COLLECT_USER_PASSWORD,
        REGISTRATION_COMPLETED
    }

    private var currentState: RegistrationState = RegistrationState.COLLECT_PROFILE_DATA

    private val compositeDisposable = CompositeDisposable()

    val fullName = BehaviorRelay.createDefault("")
    val bio = BehaviorRelay.createDefault("")

    val username = BehaviorRelay.createDefault("")
    val password = BehaviorRelay.createDefault("")

    val isRegisterAndLoginEnabled = BehaviorRelay.createDefault(false)
    val isEnterProfileNextEnabled = BehaviorRelay.createDefault(false)

    override fun onServiceRegistered() {
        combineTuple(fullName, bio)
            .subscribeBy { (fullName, bio) ->
                isEnterProfileNextEnabled.accept(fullName.isNotBlank() && bio.isNotBlank())
            }.addTo(compositeDisposable)

        combineTuple(username, password)
            .subscribeBy { (username, password) ->
                isRegisterAndLoginEnabled.accept(username.isNotBlank() && password.isNotBlank())
            }.addTo(compositeDisposable)
    }

    override fun onServiceUnregistered() {
        compositeDisposable.clear()
    }

    fun onRegisterAndLoginClicked() {
        if (isRegisterAndLoginEnabled.value!!) {
            currentState = RegistrationState.REGISTRATION_COMPLETED
            AuthenticationManager.saveRegistration(appContext)
            backstack.setHistory(History.of(ProfileKey()), StateChange.FORWARD)
        }
    }

    fun onEnterProfileNextClicked() {
        if (isEnterProfileNextEnabled.value!!) {
            currentState = RegistrationState.COLLECT_USER_PASSWORD
            backstack.goTo(CreateLoginCredentialsKey())
        }
    }

    override fun onBackEvent(): Boolean {
        if (currentState == RegistrationState.COLLECT_USER_PASSWORD) {
            currentState = RegistrationState.COLLECT_PROFILE_DATA
            return false // already dispatching, so just go back a screen
        }
        return false
    }

    override fun toBundle(): StateBundle = StateBundle().apply {
        putSerializable("currentState", currentState)
        putString("username", username.value!!)
        putString("password", password.value!!)
        putString("fullName", fullName.value!!)
        putString("bio", bio.value!!)
    }

    override fun fromBundle(bundle: StateBundle?) {
        bundle?.run {
            currentState = getSerializable("currentState") as RegistrationState
            username.accept(getString("username", ""))
            password.accept(getString("password", ""))
            fullName.accept(getString("fullName", ""))
            bio.accept(getString("bio", ""))
        }
    }
}