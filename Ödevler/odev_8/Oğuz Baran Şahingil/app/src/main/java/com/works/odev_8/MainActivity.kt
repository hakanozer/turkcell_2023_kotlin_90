package com.works.odev_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.works.odev_8.configs.Client
import com.works.odev_8.model.JwtUser
import com.works.odev_8.model.Products
import com.works.odev_8.model.User
import com.works.odev_8.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var editext_username : EditText
    lateinit var editext_password : EditText
    lateinit var btn_send : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editext_username = findViewById(R.id.editxt_username)
        editext_password = findViewById(R.id.editxt_password)
        btn_send = findViewById(R.id.btn_send)


        val dummyService = Client.getClient().create(DummyService::class.java)

        btn_send.setOnClickListener {
            val username = editext_username.text.toString()
            val password = editext_password.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()){
                val user = User(username, password)

                dummyService.login(user).enqueue(object : Callback<JwtUser> {
                    override fun onResponse(call: Call<JwtUser>, response: Response<JwtUser>) {
                        val jwtUser = response.body()
                        if (jwtUser != null) {
                            val intent = Intent(this@MainActivity, MenuList::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(
                                this@MainActivity,
                                "Username or Password is incorrect ",
                                Toast.LENGTH_LONG
                            )
                        }

                    }
                    override fun onFailure(call: Call<JwtUser>, t: Throwable) {
                        Log.e("Login Fail ", t.toString())
                        Toast.makeText(this@MainActivity, "Login Fail", Toast.LENGTH_LONG)
                            .show()
                    }
                })
            }
        }
    }
}

fun Any.enqueue(callback: Callback<Products>) {
    TODO("Not yet implemented")
}
