package com.example.koylinfasten.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import com.example.koylinfasten.R
import com.example.koylinfasten.databinding.ActivityMainBinding
import com.example.koylinfasten.fragments.FirstFragment
import com.example.koylinfasten.interfaces.IActivityTransaction

class MainActivity : AppCompatActivity(), IActivityTransaction{

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun toNextActivity() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }


}