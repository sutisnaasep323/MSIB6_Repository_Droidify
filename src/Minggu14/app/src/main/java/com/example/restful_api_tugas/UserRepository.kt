package com.example.restful_api_tugas

object UserRepository {
    fun validateUser(email: String, password: String): Boolean {
        // Logika validasi sederhana
        return email == "test@example.com" && password == "password"
    }
}