package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        calc_btn.setOnClickListener() {
            val input_weight: String = weight_in.text.toString()
            val value: Double = input_weight.toDouble()


            val input_height: String = height_in.text.toString()
            val value1: Double = input_height.toDouble()

            val bmiresult = calculate(value,value1)



            if (bmiresult < 18.5) {
                image.setImageResource(R.drawable.under)
                bmi_result.text =
                    "Your BMI is " + "%.2f".format(bmiresult) + " You are Underweight !"
            } else if (bmiresult <= 24.9) {
                image.setImageResource(R.drawable.normal)
                bmi_result.text = "Your BMI is " + "%.2f".format(bmiresult) + " You are Normal"
            } else {
                bmi_result.text = "Your BMI is " + "%.2f".format(bmiresult) + " You are Overweight !"
                image.setImageResource(R.drawable.over)

            }
        }

        reset_btn.setOnClickListener() {
            weight_in.text.clear()
            height_in.text.clear()
            bmi_result.text=""
            image.setImageResource(R.drawable.empty)


        }



    }
    fun calculate(v1: Double, v2: Double): Double {
        val bmiresult: Double = v1 / (v2 * v2)
        return bmiresult

    }
}
