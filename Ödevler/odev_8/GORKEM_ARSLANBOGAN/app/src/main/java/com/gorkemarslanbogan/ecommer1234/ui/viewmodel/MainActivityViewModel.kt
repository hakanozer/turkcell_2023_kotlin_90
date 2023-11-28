package com.gorkemarslanbogan.ecommer1234.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorkemarslanbogan.ecommer1234.model.LoginResult
import com.gorkemarslanbogan.ecommer1234.model.UserLogin
import com.gorkemarslanbogan.ecommer1234.repository.DummyServiceRepository
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val repository: DummyServiceRepository by lazy { DummyServiceRepository() }

    suspend fun checkLogin(username: String, password: String): Boolean {
        var loginResult: LoginResult? = null
        viewModelScope.launch {
            val userLogin = UserLogin(username, password)
            loginResult = repository.login(userLogin)
        }.join()
        return loginResult != null
    }
}