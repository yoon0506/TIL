package com.yoon.customviewtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = WeekFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment1).commit()

    }
}