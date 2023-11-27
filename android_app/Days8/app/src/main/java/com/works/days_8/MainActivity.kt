package com.works.days_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DB(this)
        //val id = db.addUser("Zehra Bil", "zehra@mail.com", "12345", "5432223344")
        //Log.d("id", "insert : $id")

        val deleteStatus = db.deleteUser(1)
        Log.d("status", "delete : $deleteStatus")
    }
}