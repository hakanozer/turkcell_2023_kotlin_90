package com.example.hw8_urun_tantm_uygulamas.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hw8_urun_tantm_uygulamas.R
import com.example.hw8_urun_tantm_uygulamas.databinding.FragmentLoginBinding
import com.example.hw8_urun_tantm_uygulamas.model.LoginInformation
import com.example.hw8_urun_tantm_uygulamas.model.UserInformation
import com.example.hw8_urun_tantm_uygulamas.service.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val apiResponse = ApiResponse.apiRetrofitService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        btnSend.setOnClickListener {
            val username = txtUsername.text.toString()
            val password = txtPassword.text.toString()
            if (username == null || password == null) {
                Toast.makeText(
                    requireContext(),
                    "Please, you have to write password or email",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                apiResponse.userLogin(LoginInformation(username, password)).enqueue(object :
                    Callback<UserInformation> {
                    override fun onResponse(
                        call: Call<UserInformation>,
                        response: Response<UserInformation>
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                requireContext(),
                                "Login is successful ",
                                Toast.LENGTH_SHORT
                            ).show()
                            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "You should control",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<UserInformation>, t: Throwable) {
                        Toast.makeText(
                            requireContext(),
                            "Unexpected server fail",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
            }
        }
    }
}