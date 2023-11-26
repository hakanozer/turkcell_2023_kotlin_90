package com.davutkarakus.turkcellgelecegiyazanlarodev8.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.davutkarakus.turkcellgelecegiyazanlarodev8.R
import com.davutkarakus.turkcellgelecegiyazanlarodev8.Service.DummyService
import com.davutkarakus.turkcellgelecegiyazanlarodev8.Util.getUser
import com.davutkarakus.turkcellgelecegiyazanlarodev8.configs.ApiClient
import com.davutkarakus.turkcellgelecegiyazanlarodev8.model.JWTUser
import com.davutkarakus.turkcellgelecegiyazanlarodev8.model.User
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var signInBtn:Button
    private lateinit var usernameEditText:EditText
    private lateinit var passwordEditText:EditText
    private lateinit var dummyService: DummyService
    private lateinit var checkBox: CheckBox
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("users", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        signInBtn = findViewById(R.id.singInButton)
        usernameEditText = findViewById(R.id.editTextUsername)
        passwordEditText = findViewById(R.id.editTextPassword)
        checkBox = findViewById(R.id.checkBox)
        supportActionBar?.title = "Log In"
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        val user = getUser(this)
        if (user != null){
            checkBox.isChecked = true
            usernameEditText.setText(user.username)
            passwordEditText.setText(user.password)
        }
        signInBtn.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (username.isEmpty() && password.isEmpty()){
                usernameEditText.error = "Please fill in the username field"
                passwordEditText.error = "Please fill in the password field"
            }else if (username.isEmpty()) {
                usernameEditText.error = "Please fill in the username field"
            }else if (password.isEmpty()) {
                passwordEditText.error = "Please fill in the password field"
            }else {
                if (checkBox.isChecked) {
                    val saveUser = User(username,password)
                    val gson = Gson()
                    val stData = gson.toJson(saveUser)
                    editor.putString("user",stData)
                    editor.commit()
                }else {
                    editor.clear()
                    editor.commit()
                }
                dummyService.login(User(username,password)).enqueue(object :Callback<JWTUser> {
                    override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                        if (response.isSuccessful){
                            val intent = Intent(this@LoginActivity,MainActivity::class.java)
                            startActivity(intent)
                        }else {
                            Toast.makeText(this@LoginActivity,"Username or Password Fail!", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<JWTUser>, t: Throwable) {
                        Log.e("Login Fail",t.toString())
                    }

                })
            }
        }
    }
}