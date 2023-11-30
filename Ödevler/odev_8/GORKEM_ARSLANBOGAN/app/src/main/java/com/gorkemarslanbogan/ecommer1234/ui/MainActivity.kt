package com.gorkemarslanbogan.ecommer1234.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.gorkemarslanbogan.ecommer1234.R
import com.gorkemarslanbogan.ecommer1234.helper.Utils
import com.gorkemarslanbogan.ecommer1234.ui.viewmodel.MainActivityViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var edittextUsername: EditText
    private lateinit var edittextPassword: EditText
    private lateinit var loginButton : Button
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUiComponent()
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        loginButton.setOnClickListener{loginClick()}
    }

    private fun setUiComponent(){
        edittextUsername = findViewById(R.id.editTextUsername)
        edittextPassword = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.loginButton)
    }


    private fun loginClick(){
        lifecycleScope.launch {
            if(Utils.checkEdittext(applicationContext, arrayListOf(edittextUsername, edittextPassword))) {
                if(viewModel.checkLogin(edittextUsername.text.toString(), edittextPassword.text.toString())) {
                    applicationContext.getString(R.string.str_login_success)
                    Utils.showShortToast(applicationContext, applicationContext.getString(R.string.str_login_success))
                    val intent = Intent(applicationContext, HomeScreenActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Utils.showShortToast(applicationContext, applicationContext.getString(R.string.str_user_or_password_wrong))
                }
            } else {
                Utils.showShortToast(applicationContext, applicationContext.getString(R.string.str_user_or_password_can_not_empty))
            }
        }
    }
}