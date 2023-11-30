package com.example.muhammed_zeyd_satilmis_odev8.fragments

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.muhammed_zeyd_satilmis_odev8.R
import com.example.muhammed_zeyd_satilmis_odev8.configs.ApiClient
import com.example.muhammed_zeyd_satilmis_odev8.databinding.FragmentLoginBinding
import com.example.muhammed_zeyd_satilmis_odev8.models.JWTUser
import com.example.muhammed_zeyd_satilmis_odev8.models.UserAuth
import com.example.muhammed_zeyd_satilmis_odev8.services.IDummyService
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var dummyService: IDummyService


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        dummyService = ApiClient.getClient().create(IDummyService::class.java)


        //user name: kminchelle
        //password: "0lelplR"


        binding.btnLogin.setOnClickListener {

            userLogin(it)

        }

        return binding.root

    }


    private fun userLogin(view: View) {
        val userName = binding.edtTxtUsername.text.toString().trim()
        val userPass = binding.edtTxtPassword.text.toString().trim()
        val user = UserAuth(userName, userPass)

        Log.e(userName, userPass)

        if (userName == "" || userPass == "") {
            Snackbar.make(
                view,
                "Lütfen kullanıcı adı ve şifrenizi giriniz.",
                Snackbar.LENGTH_SHORT
            ).show()
        } else if (userName.length < 4 || userPass.length < 4) {
            Snackbar.make(
                view,
                "Kullanıcı adı veya şifre 4 karakterden az olamaz.",
                Snackbar.LENGTH_SHORT
            ).show()
        } else {
            dummyService.login(user).enqueue(object : Callback<JWTUser> {
                override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                    if (response.isSuccessful) {
                        val userIdPw = response.body()

                        if (userIdPw != null) {
                            val gson = Gson()
                            val userData = gson.toJson(userIdPw)

                            Navigation.findNavController(view).navigate(R.id.route_product)
                        }
                    } else {
                        Snackbar.make(
                            view,
                            "Kullanıcı adı veya şifre hatalı.",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<JWTUser>, t: Throwable) {
                    Log.e("On Fail:", "$t")
                }
            })
        }

    }


}
