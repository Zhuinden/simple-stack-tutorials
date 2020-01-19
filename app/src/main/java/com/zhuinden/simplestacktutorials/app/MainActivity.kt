package com.zhuinden.simplestacktutorials.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhuinden.simplestacktutorials.R
import com.zhuinden.simplestacktutorials.steps.step_1.Step1Activity
import com.zhuinden.simplestacktutorials.steps.step_2.Step2Activity
import com.zhuinden.simplestacktutorials.steps.step_3.Step3Activity
import com.zhuinden.simplestacktutorials.steps.step_4.Step4Activity
import com.zhuinden.simplestacktutorials.steps.step_5.Step5Activity
import com.zhuinden.simplestacktutorials.utils.onClick
import com.zhuinden.simplestacktutorials.utils.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStep1.onClick {
            startActivity<Step1Activity>()
        }

        buttonStep2.onClick {
            startActivity<Step2Activity>()
        }

        buttonStep3.onClick {
            startActivity<Step3Activity>()
        }

        buttonStep4.onClick {
            startActivity<Step4Activity>()
        }

        buttonStep5.onClick {
            startActivity<Step5Activity>()
        }
    }
}
