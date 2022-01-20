package com.example.finaldemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finaldemo.databinding.ActivityDemo3Binding

class DemoActivity3 : AppCompatActivity() {
    lateinit var mBinding: ActivityDemo3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDemo3Binding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}