package com.example.koylinfasten.activities

import android.content.IntentFilter
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.koylinfasten.R
import com.example.koylinfasten.classes.MyReceiver
//import com.example.koylinfasten.activities.databinding.ActivityMain6Binding
import com.example.koylinfasten.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {

    lateinit var receiver: MyReceiver
    lateinit var intentFilter: IntentFilter

    //private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        receiver = MyReceiver()
        intentFilter = IntentFilter("android.intent.action.BOOT_COMPLETED");
        val navController = findNavController(R.id.nav_host_fragment_content_main5)
        //appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onResume() {
        super.onResume()

        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(receiver)
    }


}