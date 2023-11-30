package com.works.homework_8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.works.homework_8.configs.ApiClient
import com.works.homework_8.databinding.ActivityMainBinding
import com.works.homework_8.services.DummyJsonService
import com.works.homework_8.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var dummyService: DummyJsonService
        dummyService = ApiClient.getClient().create(DummyJsonService::class.java)

        binding.loginButton.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val pass = binding.editTextTextPassword.text.toString()
            val user = User(email, pass)
            dummyService.login(user).enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val jwtUser = response.body()
                    Log.d("status", response.code().toString())
                    if (jwtUser != null) {
                        val intent = Intent(this@MainActivity, ProductsActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.e("login", t.toString())
                    Toast.makeText(this@MainActivity, "Internet or Server Fail", Toast.LENGTH_LONG)
                        .show()
                }
            })
        }
    }
}
