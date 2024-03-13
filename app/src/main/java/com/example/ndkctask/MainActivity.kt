package com.example.ndkctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.jni.NativeLib
import com.example.ndkctask.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        result = binding.totalResult

        binding.plusButton.setOnClickListener {
            calculateAndSetResult { NativeLib().Add(it.first, it.second) }
        }

        binding.minusButton.setOnClickListener {
            calculateAndSetResult { NativeLib().Subtract(it.first, it.second) }
        }

        binding.multiplyButton.setOnClickListener {
            calculateAndSetResult { NativeLib().Multiply(it.first, it.second) }
        }

        binding.divideButton.setOnClickListener {
            calculateAndSetResult { NativeLib().Divide(it.first, it.second) }
        }
    }

    private fun calculateAndSetResult(operation: (Pair<Int, Int>) -> Int) {
        val num1Text = binding.first.text.toString()
        val num2Text = binding.Second.text.toString()

        if (num1Text.isNotEmpty() && num2Text.isNotEmpty()) {
            val num1 = num1Text.toInt()
            val num2 = num2Text.toInt()
            val resultValue = operation.invoke(Pair(num1, num2))
            result.text = resultValue.toString()

            /*// Clear the input fields
            binding.first.text?.clear()
            binding.Second.text?.clear()*/
        } else {
            result.text = "Invalid input"
        }
    }
}
