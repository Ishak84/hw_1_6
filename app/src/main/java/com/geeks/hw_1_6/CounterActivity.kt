package com.geeks.hw_1_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.geeks.hw1_6m.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCounterBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[CounterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnInc.setOnClickListener {
                viewModel.updateCounterData(true)
            }
            btnDec.setOnClickListener {
                viewModel.updateCounterData(false)
            }
            viewModel.counterLD.observe(this@CounterActivity) { result ->
                tvResult.text = result.toString()
            }
        }
    }
}