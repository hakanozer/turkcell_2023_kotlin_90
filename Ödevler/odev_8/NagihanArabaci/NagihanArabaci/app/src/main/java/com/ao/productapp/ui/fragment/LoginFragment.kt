package com.ao.productapp.ui.fragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ao.productapp.R
import com.ao.productapp.databinding.FragmentLoginBinding
import com.ao.productapp.model.JWTUser
import com.ao.productapp.model.Product
import com.ao.productapp.model.Products
import com.ao.productapp.model.UserSend
import com.ao.productapp.retrofit.DummyJsonApi
import com.ao.productapp.retrofit.DummyJsonService
import com.google.gson.Gson

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    lateinit var dummyService: DummyJsonService
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private lateinit var userSend: UserSend


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        userControl(binding)
        return binding.root
    }

    private fun userControl(binding:FragmentLoginBinding){
        binding.loginBtn.setOnClickListener {
            sharedPreferences = requireActivity().getSharedPreferences("users", AppCompatActivity.MODE_PRIVATE)
            editor =  sharedPreferences.edit()
            val userName = binding.emailEt.text.toString().trim()
            val userPassword = binding.PassEt.text.toString().trim()
            if (userName.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(binding.root.context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }else {
                userSend = UserSend(userName, userPassword)
                dummyService = DummyJsonApi.getClient().create(DummyJsonService::class.java)
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
                                val direction = LoginFragmentDirections.actionLoginFragmentToProductsFragment()
                                findNavController().navigate(direction)
                            }
                        }else {
                            Toast.makeText(binding.root.context, "Usernema or Password Fail!", Toast.LENGTH_SHORT).show()
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