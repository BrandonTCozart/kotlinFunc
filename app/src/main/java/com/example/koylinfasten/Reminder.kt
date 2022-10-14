package com.example.koylinfasten

open class Reminder(var textRemind: String, var dateRemind: String, var timeRemind: String, override var creationDate: String, override var creationTime: String):Creation {

    companion object{

        fun createReminderList(numNotes: Int): ArrayList<Reminder>{
            val reminderz = ArrayList<Reminder>()
            for (i in 1..numNotes){

                reminderz.add(Reminder("task $i", " Random date ", "", "", ""))

            }
            return reminderz
        }
    }

}