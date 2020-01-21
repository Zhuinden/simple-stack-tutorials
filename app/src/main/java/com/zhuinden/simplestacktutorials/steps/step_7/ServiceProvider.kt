package com.zhuinden.simplestacktutorials.steps.step_7

import com.zhuinden.simplestack.ScopedServices
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestacktutorials.steps.step_7.core.navigation.FragmentKey
import com.zhuinden.simplestacktutorials.steps.step_7.core.viewmodels.HasServices
import com.zhuinden.simplestacktutorials.steps.step_7.core.viewmodels.add
import com.zhuinden.simplestacktutorials.steps.step_7.features.registration.RegistrationViewModel

class ServiceProvider : ScopedServices {
    override fun bindServices(serviceBinder: ServiceBinder) {
        val key = serviceBinder.getKey<FragmentKey>()

        if (key is HasServices) {
            key.bindServices(serviceBinder) // screen-bound shared services
        }

        val scope = serviceBinder.scopeTag

        with(serviceBinder) {
            when (scope) { // explicit shared services
                "registration" -> add(
                    RegistrationViewModel(
                        lookupService("appContext"),
                        backstack
                    )
                )
            }
        }
    }
}