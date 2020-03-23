package com.zhuinden.simplestacktutorials.steps.step_9.features.login

import android.content.Context
import com.jakewharton.rxrelay2.BehaviorRelay
import com.zhuinden.rxcombinetuplekt.combineTuple
import com.zhuinden.simplestack.*
import com.zhuinden.simplestacktutorials.steps.step_9.AuthenticationManager
import com.zhuinden.simplestacktutorials.steps.step_9.features.profile.ProfileKey
import com.zhuinden.simplestacktutorials.steps.step_9.features.registration.EnterProfileDataKey
import com.zhuinden.statebundle.StateBundle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class LoginViewModel(
    private val appContext: Context,
    private val backstack: Backstack
) : Bundleable, ScopedServices.Registered {
    private val compositeDisposable = CompositeDisposable()

    val username = BehaviorRelay.createDefault("")
    val password = BehaviorRelay.createDefault("")

    val isLoginEnabled = BehaviorRelay.createDefault(false)

    override fun onServiceRegistered() {
        combineTuple(username, password)
            .subscribeBy { (username, password) ->
                isLoginEnabled.accept(username.isNotBlank() && password.isNotBlank())
            }.addTo(compositeDisposable)
    }

    override fun onServiceUnregistered() {
        compositeDisposable.clear()
    }

    fun onLoginClicked() {
        if (isLoginEnabled.value!!) {
            AuthenticationManager.saveRegistration(appContext)
            backstack.setHistory(History.of(ProfileKey()), StateChange.FORWARD)
        }
    }

    fun onRegisterClicked() {
        backstack.goTo(EnterProfileDataKey())
    }

    override fun toBundle(): StateBundle = StateBundle().apply {
        putString("username", username.value!!)
        putString("password", password.value!!)
    }

    override fun fromBundle(bundle: StateBundle?) {
        bundle?.run {
            username.accept(getString("username", ""))
            password.accept(getString("password", ""))
        }
    }
}