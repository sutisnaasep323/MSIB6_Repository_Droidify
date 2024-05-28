package com.example.restful_api_tugas

import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null

    fun isValidCredentials(): Boolean {
        return !email.isNullOrBlank() && !password.isNullOrBlank() && email!!.contains("@")
    }
}