package com.example.odev_8

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.odev_8.configs.ApiClient
import com.example.odev_8.models.JWTUser
import com.example.odev_8.models.UserSend
import com.example.odev_8.services.DummyService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var edtKullanici: EditText
    lateinit var edtPassword: EditText
    lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtKullanici = findViewById(R.id.edtKullanici)
        edtPassword = findViewById(R.id.edtPassword)
        btnSend = findViewById(R.id.btnSend)

        sharedPreferences = getSharedPreferences("users", AppCompatActivity.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        btnSend.setOnClickListener {
            val username = edtKullanici.text.toString()
            val password = edtPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                val userSend = UserSend(username, password)

                dummyService.login(userSend).enqueue(object : Callback<JWTUser> {
                    override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                        val user = response.body()
                        if (user != null) {
                            // Kullanıcı adı doğru
                            val gson = Gson()
                            val stData = gson.toJson(user)
                            editor.putString("user", stData)
                            editor.apply()

                            val intent = Intent(this@MainActivity, ProductList::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@MainActivity, "Kullanıcı adı veya şifre yanlış!", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<JWTUser>, t: Throwable) {
                        Log.e("Login Fail", t.toString())
                    }
                })
            } else {
                Toast.makeText(this@MainActivity, "Lütfen kullanıcı adı ve şifre girin", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
