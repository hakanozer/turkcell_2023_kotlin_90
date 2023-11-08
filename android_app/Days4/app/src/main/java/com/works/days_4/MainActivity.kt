package com.works.days_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val run = Runnable {
            val arr = EczaneResult().gaziAntep()
        }
        Thread(run).start()


    }
}