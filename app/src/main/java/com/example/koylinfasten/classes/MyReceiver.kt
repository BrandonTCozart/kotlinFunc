package com.example.koylinfasten.classes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {

        //Toast.makeText(context, "Action: " + intent.action, Toast.LENGTH_SHORT).show()
        if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
            val serviceIntent = Intent(context, MyReceiver::class.java)
            context!!.startService(serviceIntent)
        }

    }
}