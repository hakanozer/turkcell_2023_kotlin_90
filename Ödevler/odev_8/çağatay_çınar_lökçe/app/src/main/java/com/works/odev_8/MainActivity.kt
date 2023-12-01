package com.works.odev_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.works.odev_8.adapter.CustomAdapter
import com.works.odev_8.databinding.ActivityMainBinding
import com.works.odev_8.models.JWTUser
import com.works.odev_8.models.Products
import com.works.odev_8.models.UserSend
import com.works.odev_8.network.ApiClient
import com.works.odev_8.network.services.DummyService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var dummyService: DummyService
    private lateinit var binding: ActivityMainBinding
    private lateinit var userSend: UserSend
    private lateinit var userPassword: String
    private lateinit var userName: String
    private lateinit var loginStatus: String
    private lateinit var products: Products

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dummyService = ApiClient.getClient().create(DummyService::class.java)


        binding.btnLogin.setOnClickListener {
            userName = binding.editTextUserName.text.toString()
            userPassword = binding.editTextPassword.text.toString()

            if (userName.isEmpty() || userPassword.isEmpty()){
                Toast.makeText(applicationContext,"Kullanıcı adı veya şifre boş olamaz.",Toast.LENGTH_LONG).show()
            }else{
                userSend = UserSend(userName,userPassword)
                lifecycleScope.launch(Dispatchers.IO) {

                    dummyService.login(userSend).enqueue(object : Callback<JWTUser>{
                        override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                            val statusCode = response.code()

                            if (statusCode==200){
                                loginStatus = "Giriş Başarılı"
                                val userModel = response.body()
                                Log.d("durumkodu", "onResponse: $userModel")
                                val loginToList = Intent(applicationContext,ProductsListActivity::class.java)
                                startActivity(loginToList)
                            }else{
                                loginStatus = "Hata, kullanıcı adı veya şifre yanlış."
                                val userModel = response.body()
                                Log.d("durumkodu", "onResponse: $userModel")
                            }

                            Toast.makeText(applicationContext,loginStatus,Toast.LENGTH_SHORT).show()
                        }

                        override fun onFailure(call: Call<JWTUser>, t: Throwable) {
                            TODO("Not yet implemented")
                        }

                    })



            }
            }
        }

    }
}