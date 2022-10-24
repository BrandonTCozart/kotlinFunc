package com.example.koylinfasten.classes

import com.example.koylinfasten.interfaces.Creation

open class Reminder(var textRemind: String, var timeRemind: String,var reminderID: String, override var creationTime: String):
    Creation {

    companion object{

        fun createReminderList(numNotes: Int): ArrayList<Reminder>{
            val reminderz = ArrayList<Reminder>()
            for (i in 1..numNotes){

                reminderz.add(Reminder("task $i", " Random date ", "", ""))

            }
            return reminderz
        }
    }

}