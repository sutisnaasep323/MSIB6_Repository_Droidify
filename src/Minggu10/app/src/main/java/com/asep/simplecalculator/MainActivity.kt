package com.asep.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnResult = findViewById<Button>(R.id.buttonHasil)

        btnResult.setOnClickListener {
            Toast.makeText(this, "Move to Result Activity", Toast.LENGTH_SHORT).show()
        }
    }
}