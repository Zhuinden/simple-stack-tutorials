package com.zhuinden.simplestacktutorials.steps.step_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger
import com.zhuinden.simplestack.navigator.Navigator
import com.zhuinden.simplestacktutorials.R
import kotlinx.android.synthetic.main.activity_step6.*

class Step6Activity : AppCompatActivity(), StateChanger {
    private lateinit var fragmentStateChanger: FragmentStateChanger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step6)

        fragmentStateChanger = FragmentStateChanger(supportFragmentManager, R.id.step6Root)

        Navigator.configure()
            .setStateChanger(this)
            .install(this, step6Root, History.of(Step6FirstScreen()))
    }

    override fun onBackPressed() {
        if (!Navigator.onBackPressed(this)) {
            super.onBackPressed()
        }
    }

    override fun handleStateChange(stateChange: StateChange, completionCallback: StateChanger.Callback) {
        if (stateChange.isTopNewKeyEqualToPrevious) {
            completionCallback.stateChangeComplete()
            return
        }

        fragmentStateChanger.handleStateChange(stateChange)
        completionCallback.stateChangeComplete()
    }
}