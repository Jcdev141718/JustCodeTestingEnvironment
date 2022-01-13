package com.example.finaldemo.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finaldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        clickListner()
    }

    private fun clickListner() {
        mBinding.btnDemo1.setOnClickListener {
            jumpToActivity(DemoActivity1())
        }
        mBinding.btnDemo2.setOnClickListener {
            jumpToActivity(DemoActivity2())
        }
        mBinding.btnDemo3.setOnClickListener {
            jumpToActivity(DemoActivity3())
        }
        mBinding.btnDemo4.setOnClickListener {
            jumpToActivity(DemoActivity4())
        }
    }

    private fun jumpToActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}