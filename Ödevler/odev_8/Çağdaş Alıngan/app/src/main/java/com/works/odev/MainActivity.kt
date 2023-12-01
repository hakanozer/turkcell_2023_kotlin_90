package com.works.odev

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.works.odev.config.ApiClient
import com.works.odev.databinding.ActivityMainBinding
import com.works.odev.model.JWTUser
import com.works.odev.model.UserSend
import com.works.odev.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var dummyService: DummyService
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("users", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        binding.btnSend.setOnClickListener {
            val username = binding.editUser.text.toString()
            val password = binding.editPass.text.toString()
            val users = UserSend(username,password)
            if (users.username.equals("kminchelle") && users.password.equals("0lelplR")){
                dummyService.login(users).enqueue(object : Callback<JWTUser>{
                    override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                        val user = response.body()
                         Log.d("users", response.code().toString())
                        if (user != null){
                            val intent = Intent(this@MainActivity,ProductList::class.java)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<JWTUser>, t: Throwable) {
                        Log.e("Fail",t.toString() )
                    }
                })
            }else{
                Toast.makeText(applicationContext,"Username or Password fail",Toast.LENGTH_SHORT).show()
            }
        }

    }


}