package com.example.koylinfasten.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.koylinfasten.R
import com.example.koylinfasten.fragments3.First3Fragment

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, First3Fragment.newInstance())
                .commitNow()
        }
    }
}