package com.zhuinden.simplestacktutorials.steps.step_9.features.registration

import android.os.Bundle
import android.view.View
import com.zhuinden.simplestacktutorials.R
import com.zhuinden.simplestacktutorials.steps.step_9.core.navigation.BaseFragment
import com.zhuinden.simplestacktutorials.steps.step_9.core.navigation.backstack
import com.zhuinden.simplestacktutorials.steps.step_9.core.viewmodels.lookup
import com.zhuinden.simplestacktutorials.steps.step_9.utils.get
import com.zhuinden.simplestacktutorials.utils.onClick
import com.zhuinden.simplestacktutorials.utils.onTextChanged
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.step9_create_login_credentials_fragment.*

class CreateLoginCredentialsFragment : BaseFragment(R.layout.step9_create_login_credentials_fragment) {
    private val viewModel by lazy { backstack.lookup<RegistrationViewModel>() }

    private val compositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textUsername.setText(viewModel.username.get())
        textPassword.setText(viewModel.password.get())

        viewModel.isRegisterAndLoginEnabled.distinctUntilChanged().subscribeBy { enabled ->
            buttonRegisterAndLogin.isEnabled = enabled
        }.addTo(compositeDisposable)

        textUsername.onTextChanged { username -> viewModel.username.accept(username) }
        textPassword.onTextChanged { password -> viewModel.password.accept(password) }
        buttonRegisterAndLogin.onClick { viewModel.onRegisterAndLoginClicked() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }
}