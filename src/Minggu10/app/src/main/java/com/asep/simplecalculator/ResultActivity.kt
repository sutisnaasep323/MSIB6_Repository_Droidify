package com.asep.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewHasil = findViewById<TextView>(R.id.textViewHasil)

        val hasil = intent.getFloatExtra(EXTRA_HASIL, 0f)
        textViewHasil.text = "Hasil: $hasil"
    }

    companion object {
        const val EXTRA_HASIL = "extra_hasil"
    }
}