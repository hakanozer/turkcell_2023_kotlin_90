package com.works.days_7

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.works.days_7.configs.ApiClient
import com.works.days_7.models.JWTUser
import com.works.days_7.models.UserSend
import com.works.days_7.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("users", MODE_PRIVATE)
        editor =  sharedPreferences.edit()

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        val userSend = UserSend("kminchelle", "0lelplR")
        dummyService.login(userSend).enqueue(object: Callback<JWTUser> {
            override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                val status = response.code()
                if (status == 200) {
                    val user = response.body()
                    if (user != null) {

                        val gson = Gson()
                        val stData = gson.toJson(user)
                        editor.putString("user", stData)
                        editor.commit()

                        val intent = Intent(this@MainActivity, ProductList::class.java)
                        startActivity(intent)

                    }
                }else {
                    Toast.makeText(this@MainActivity, "Usernema or Password Fail!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<JWTUser>, t: Throwable) {
                Log.e("Login Fail", t.toString() )
            }
        })

    }


}