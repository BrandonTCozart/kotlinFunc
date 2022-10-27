package com.example.koylinfasten.interfaces

interface IActivityTransaction {
    fun toNextActivity() {}
    fun toPostActivity(){}
    fun toFirstActivity(){}
}