package com.nazlican.turkcellgelecegiyazanlarhomework8.ui.fragment
// username: kminchelle password: 0lelplR
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.nazlican.turkcellgelecegiyazanlarhomework8.R
import com.nazlican.turkcellgelecegiyazanlarhomework8.common.viewBinding
import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.JwtUser
import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.User
import com.nazlican.turkcellgelecegiyazanlarhomework8.databinding.FragmentLoginBinding
import com.nazlican.turkcellgelecegiyazanlarhomework8.common.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private lateinit var user: User
    private val productService = RetrofitClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            with(binding) {
                val userName = signInUserName2.text.toString().trim()
                val password = signInPassword2.text.toString().trim()

                sharedPreferences =
                    requireActivity().getSharedPreferences("users", Context.MODE_PRIVATE)
                editor = sharedPreferences.edit()

                if (userName.isEmpty() || password.isEmpty()) {
                    Snackbar.make(
                        root,
                        "Please enter both username and password",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    user = User(userName, password)

                    productService.service?.login(user)?.enqueue(object : Callback<JwtUser> {
                        override fun onResponse(call: Call<JwtUser>, response: Response<JwtUser>) {
                            if (response.isSuccessful) {
                                val user = response.body()
                                if (user != null) {
                                    val gson = Gson()
                                    val stData = gson.toJson(user)
                                    editor.putString("user", stData)
                                    editor.apply()
                                    findNavController().navigate(R.id.signInToHome)
                                }
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Username or Password Fail!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onFailure(call: Call<JwtUser>, t: Throwable) {
                            Snackbar.make(
                                root,
                                "Error: ${t.localizedMessage}",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                    })
                }
            }
        }
    }
}