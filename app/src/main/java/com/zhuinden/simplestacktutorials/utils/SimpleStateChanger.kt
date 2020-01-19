package com.zhuinden.simplestacktutorials.utils

import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger

class SimpleStateChanger(
    private val navigationHandler: NavigationHandler
) : StateChanger {
    interface NavigationHandler {
        fun handleNavigationEvent(stateChange: StateChange)
    }

    override fun handleStateChange(stateChange: StateChange, completionCallback: StateChanger.Callback) {
        if (stateChange.isTopNewKeyEqualToPrevious) {
            completionCallback.stateChangeComplete()
            return
        }

        navigationHandler.handleNavigationEvent(stateChange)
        completionCallback.stateChangeComplete()
    }
}