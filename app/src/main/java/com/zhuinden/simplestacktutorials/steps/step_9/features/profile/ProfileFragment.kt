package com.zhuinden.simplestacktutorials.steps.step_9.features.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zhuinden.simplestacktutorials.R
import com.zhuinden.simplestacktutorials.steps.step_9.core.navigation.BaseFragment

class ProfileFragment : BaseFragment(R.layout.step9_profile_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "Welcome!", Toast.LENGTH_LONG).show()
    }
}