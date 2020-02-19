package com.zhuinden.simplestacktutorials.steps.step_8.features.form

import androidx.fragment.app.Fragment
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestacktutorials.steps.step_8.core.navigation.FragmentKey
import com.zhuinden.simplestacktutorials.steps.step_8.core.viewmodels.HasServices
import com.zhuinden.simplestacktutorials.steps.step_8.core.viewmodels.add
import com.zhuinden.simplestacktutorials.steps.step_8.core.viewmodels.lookup
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FormKey(private val placeholder: String = ""): FragmentKey(), HasServices {
    override fun instantiateFragment(): Fragment = FormFragment()

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder) {
            add(FormViewModel(lookup(), backstack))
        }
    }
}