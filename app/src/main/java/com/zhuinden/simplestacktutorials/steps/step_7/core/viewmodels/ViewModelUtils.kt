package com.zhuinden.simplestacktutorials.steps.step_7.core.viewmodels

import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.ServiceBinder

inline fun <reified T> ServiceBinder.add(service: T) {
    this.addService(T::class.java.name, service as Any)
}

inline fun <reified T> Backstack.lookup() = lookupService<T>(T::class.java.name)