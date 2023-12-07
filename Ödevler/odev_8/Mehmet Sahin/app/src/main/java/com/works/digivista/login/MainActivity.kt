package com.works.digivista.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.works.digivista.ProductList
import com.works.digivista.configs.ApiClient
import com.works.digivista.databinding.ActivityMainBinding
import com.works.digivista.models.JWTUser
import com.works.digivista.models.UserSend
import com.works.digivista.services.DummyService
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
        validateAndLoginButton()
}
private fun validateAndLoginButton() {
    //val userSend = UserSend("kminchelle", "0lelplR")
    binding.btnLogin.setOnClickListener {
        //kullanıcı girdisi,boşluk alma(baştaki ve sondaki)
        val username = binding.txtUserName.text.toString().trim()
        val password = binding.txtPassword.text.toString().trim()
        //validate et input boş değilse UserSend oluştur
        if (validate(username, password)) {
            loginUser(UserSend(username, password))
        } else {
            showMessage("Lütfen kullanıcı adınızı ve şifrenizi giriniz")
        }

    }
}
    private fun validate(username: String, password: String): Boolean {
        return username.isNotEmpty() && password.isNotEmpty()
    }

    private fun loginUser(userSend: UserSend) {
        dummyService.login(userSend).enqueue(object : Callback<JWTUser> {
            override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                val status = response.code()
                if (status == 200) {
                    val user = response.body()
                    if (user != null) {
                        startProductActivity()
                    }
                } else {
                    showMessage("Kullanıcı adı veya parola hatalı!")
                }
            }

            override fun onFailure(call: Call<JWTUser>, t: Throwable) {
                Log.e("Login Fail", t.toString())
                showMessage("Giriş başarısız! Lütfen tekrar deneyiniz")
            }
        })

    }

    private fun startProductActivity() {
        val intent = Intent(this@MainActivity, ProductList::class.java)
        startActivity(intent)
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }

}