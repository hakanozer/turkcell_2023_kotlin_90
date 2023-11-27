package com.bugcompany.dummyjsonapp.ui.login

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bugcompany.dummyjsonapp.R
import com.bugcompany.dummyjsonapp.common.ApiUtils
import com.bugcompany.dummyjsonapp.data.model.user.JwtUser
import com.bugcompany.dummyjsonapp.data.model.user.UserSend
import com.bugcompany.dummyjsonapp.databinding.CustomDialogBinding
import com.bugcompany.dummyjsonapp.databinding.FragmentSignInBinding
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private lateinit var userSend: UserSend
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: Editor
    private val service = ApiUtils.productApiService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val userName = binding.txtUsername.text.toString().trim()
            val password = binding.txtPassword.text.toString().trim()

            sharedPreferences = requireActivity().getSharedPreferences("users", Context.MODE_PRIVATE)
            editor = sharedPreferences.edit()

            if (userName.isEmpty()) {
                showCustomDialog()
            } else if (password.isEmpty()) {
                showCustomDialog()
            } else {
                userSend = UserSend(userName, password)

                service.login(userSend).enqueue(object : Callback<JwtUser> {
                    override fun onResponse(call: Call<JwtUser>, response: Response<JwtUser>) {
                        // username: kminchelle password: 0lelplR
                        if (response.isSuccessful) {
                            Toast.makeText(requireContext(), "Login Success", Toast.LENGTH_SHORT).show()
                            val user = response.body()
                            if (user != null) {
                                //  Log.d("User", user.toString())
                                val gson = Gson()
                                val stData = gson.toJson(user)
                                editor.putString("user", stData)
                                editor.commit()
                                findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
                            }
                        } else {
                            Toast.makeText(requireContext(), "Username or Password Fail!", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<JwtUser>, t: Throwable) {
                        Toast.makeText(requireContext(), "${t.printStackTrace()}", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }

    //Kullanıcı boş değer girince uyarı çıkan Dialog.
    private fun showCustomDialog() {
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)

        // dialogBinding.root ile dialoga görünümü atar.
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        dialogBinding.buttonOk.setOnClickListener {
            dialog.dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}




