package com.works.days_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.works.days_2.model.UserData

class MainActivity : AppCompatActivity() {

    lateinit var btnGotoDashboard: Button
    lateinit var txtData: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGotoDashboard = findViewById(R.id.btnGotoDashboard)
        txtData = findViewById(R.id.txtData)

        btnGotoDashboard.setOnClickListener {

            // use static
            val user = UserData("Erkan", "Bilmem", "erkan@mail.com", 100)
            Dashboard.user = user

            val data = txtData.text.toString()
            val intentDashboard = Intent(this, Dashboard::class.java )
            intentDashboard.putExtra("dataKey", data)
            intentDashboard.putExtra("age", 25)
            startActivity(intentDashboard)
        }

    }

}