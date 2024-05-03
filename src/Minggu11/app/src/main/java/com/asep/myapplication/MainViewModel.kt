package com.asep.myapplication

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    private var data: String = "Hello, World!"

    // Metode untuk mendapatkan data
    fun getData(): String {
        return data
    }

    // Metode untuk memperbarui data
    fun updateData(newData: String) {
        data = newData
    }
}