package com.zhuinden.simplestacktutorials.steps.step_7.features.profile

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.ScopedServices
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestacktutorials.steps.step_7.AuthenticationManager
import com.zhuinden.simplestacktutorials.steps.step_7.features.login.LoginKey

class ProfileViewModel(
    private val appContext: Context,
    private val backstack: Backstack
) : ScopedServices.Activated {
    private val handler = Handler(Looper.getMainLooper())

    override fun onServiceActive() {
        handler.post /* bypass #215, will be fixed in simple-stack version > 2.2.2 */ {
            if (!AuthenticationManager.isAuthenticated(appContext)) {
                backstack.setHistory(History.of(LoginKey()), StateChange.REPLACE)
            }
        }
    }

    override fun onServiceInactive() {
    }
}