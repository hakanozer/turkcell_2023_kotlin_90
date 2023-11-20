package com.works.days_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.works.days_7.configs.ApiClient
import com.works.days_7.models.JWTUser
import com.works.days_7.models.UserSend
import com.works.days_7.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService: DummyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        val userSend = UserSend("kminchell", "0lelplR")
        dummyService.login(userSend).enqueue(object: Callback<JWTUser> {
            override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                val status = response.code()
                if (status == 200) {
                    val user = response.body()
                    if (user != null) {
                        Log.d("User", user.toString())
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