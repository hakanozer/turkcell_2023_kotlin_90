package com.example.esmasalkim_odev8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.esmasalkim_odev8.confige.ApiClient
import com.example.esmasalkim_odev8.models.JWTUser
import com.example.esmasalkim_odev8.models.UserSend
import com.example.esmasalkim_odev8.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var txtUserName: TextView
    lateinit var txtPassword: TextView
    lateinit var btnLogin: Button

    lateinit var dummyService: DummyService




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUserName = findViewById(R.id.txtUserName)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        dummyService = ApiClient.getClient().create(DummyService::class.java) // interface class haline gelmiş oldu. Buna reflection denir.

        btnLogin.setOnClickListener {
            val username = txtUserName.text.toString().trim()
            val password = txtPassword.text.toString().trim()
            val userSend = UserSend (username, password)

            if (userSend.username == "kminchelle" && userSend.password == "0lelplR"){
                dummyService.login(userSend).enqueue(object : Callback<JWTUser> {
                    override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                        // object olan abstract ı aşağıdaki iki fonk. override etmemiz lazım
                            val status = response.code() // 200 kodunu yakalama
                            Log.d("Status", status.toString()) // username ve password yanlış yazılırsa lod'da Status değeri 400 döner. Doğru yazılmışsa 200 döner.

                            if (status == 200){   // bu kontrolun yapılması şart
                                val user = response.body() // body belli başlı listler ile gelir
                                if (user != null){  // bunun altında istediğimiz gibi gezintiye çıkabiliriz
                                    Log.d("User", user.toString()) // toString ile içindeki bütün verilere ulaşabiliri

                                    // sayfa geçiş
                                    val intent = Intent (this@MainActivity, ProductActivity::class.java)
                                    startActivity(intent)

                                }
                            }else{
                                Toast.makeText(this@MainActivity, "Username or Passsword Fail", Toast.LENGTH_SHORT).show()
                            }
                        }


                    override fun onFailure(call: Call<JWTUser>, t: Throwable) {
                        Log.e("Login Fail", t.toString())
                    }
                })

            }else{
                Toast.makeText(this@MainActivity, "Username or Passsword Fail", Toast.LENGTH_SHORT).show()

            }
        }

    }
}