package com.works.a1_days


import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var txtEmail: EditText
    lateinit var txtPassword: EditText
    lateinit var btnSend: Button
    lateinit var emailColor:Drawable
    lateinit var swtRemember: Switch
    var rememberStatus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)
        btnSend = findViewById(R.id.btnSend)
        swtRemember = findViewById(R.id.swtRemember)
        rememberStatus = swtRemember.isChecked

        emailColor = txtEmail.background
        txtEmail.setOnClickListener {
            //it.setBackgroundColor(Color.RED)
        }

        txtEmail.addTextChangedListener {
            Log.d("",  it.toString())
            val data = it.toString()
            if (data.lowercase().contains("ali".lowercase())) {
                txtEmail.setBackgroundColor(Color.RED)
            }else {
                txtEmail.setBackgroundDrawable(emailColor)
            }
        }

        btnSend.setOnClickListener(btnOnClick)
        swtRemember.setOnCheckedChangeListener { compoundButton, status ->
            rememberStatus = status
            //Log.d("Remember", status.toString())
        }
    }

    val btnOnClick = View.OnClickListener {
        val email = txtEmail.text.toString()
        val password = txtPassword.text.toString()
        if (email.equals("erkan@mail.com") && password.equals("12345")) {
            Log.d("Status",  ": Login Success ")
            Log.d("Remember", rememberStatus.toString())
        }else {
            Log.d("Status",  ": Login Fail ")
        }
    }

}