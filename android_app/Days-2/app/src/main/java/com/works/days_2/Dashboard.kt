package com.works.days_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.works.days_2.model.UserData

class Dashboard : AppCompatActivity() {

    companion object {
        var user = UserData("","","",0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        Log.d("user", user.toString())

        val pullData = intent.getStringExtra("dataKey")
        val pullAge = intent.getIntExtra("age", 0)
        if (pullData != null) {
            Log.d("",  pullData)
        }

        if (pullAge > 0) {
            Log.d("Age",  ""+pullAge)
        }

    }
}