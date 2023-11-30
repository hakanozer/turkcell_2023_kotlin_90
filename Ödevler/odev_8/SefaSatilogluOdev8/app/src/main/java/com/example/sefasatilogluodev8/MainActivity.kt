package com.example.sefasatilogluodev8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sefasatilogluodev8.configs.ApiClient
import com.example.sefasatilogluodev8.databinding.ActivityMainBinding
import com.example.sefasatilogluodev8.models.JWTData
import com.example.sefasatilogluodev8.models.JWTUser
import com.example.sefasatilogluodev8.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dummyService: DummyService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        binding.btnLogin.setOnClickListener {
            val username = binding.edtKullanici.text.toString().trim()
            val password = binding.edtSifre.text.toString().trim()
            val jwtUser = JWTUser(username,password)
            if (jwtUser.username == "kminchelle" && jwtUser.password == "0lelplR") {
                dummyService.login(jwtUser).enqueue(object : Callback<JWTData> {
                    //HTTP istegi basarili bir sekilde tamamlandiginda
                    override fun onResponse(call: Call<JWTData>, response: Response<JWTData>) {
                        //Response:HTTP istegine karsilik olarak sunucudan donen yaniti temsil eder
                        //Body: HTTP yanitinin icinde yer alan istegin sonucunu tasiyan kisma denir
                        val user = response.body()
                        Log.d("user-status",response.code().toString())
                        //Eger giris basarili ise ProductList'e gider
                        if (user != null) {
                            val intent = Intent(this@MainActivity,ProductList::class.java)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<JWTData>, t: Throwable) {
                        //t parametresi ile hatanin detaylari alinir. Hata genellikle "Throwable" tipindedir.
                        Log.e("Login Fail", t.toString() )
                    }
                })

            }else {
                //Eger kullanici adi veya sifre hatali ise
                Toast.makeText(applicationContext,"Username or PassWord Fail",Toast.LENGTH_SHORT).show()
            }
        }


    }
}