package com.ao.productsapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.widget.Toast
import com.ao.productsapp.configs.ApiClient
import com.ao.productsapp.databinding.ActivityMainBinding
import com.ao.productsapp.model.JWTUser
import com.ao.productsapp.model.UserSend
import com.ao.productsapp.services.DummyService
import com.ao.productsapp.ui.activity.ProductActivity
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var dummyService: DummyService
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private lateinit var userSend: UserSend

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userControl(binding)



}

    private fun userControl(binding:ActivityMainBinding){
        binding.buttonLogin.setOnClickListener {
            sharedPreferences = getSharedPreferences("users", MODE_PRIVATE)
            editor =  sharedPreferences.edit()
            val userName = binding.textInputName.text.toString().trim()
            val userPassword = binding.textInputPassword.text.toString().trim()
            if (userName.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }else {
                userSend = UserSend(userName, userPassword)
                dummyService = ApiClient.getClient().create(DummyService::class.java)
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
                                val intent = Intent(this@MainActivity, ProductActivity::class.java)
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

    }
}