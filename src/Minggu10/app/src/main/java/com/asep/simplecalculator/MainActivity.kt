package com.asep.simplecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNilai1 = findViewById<EditText>(R.id.edt_nilai1)
        val editTextNilai2 = findViewById<EditText>(R.id.edt_nilai2)
        val radioGroupOperasi = findViewById<RadioGroup>(R.id.radioGroupOperasi)
        val buttonHasil = findViewById<Button>(R.id.buttonHasil)

        buttonHasil.setOnClickListener {
            val nilai1 = editTextNilai1.text.toString().toFloatOrNull()
            val nilai2 = editTextNilai2.text.toString().toFloatOrNull()

            if (nilai1 == null || nilai2 == null) {
                Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hasil = when (radioGroupOperasi.checkedRadioButtonId) {
                R.id.radioButtonTambah -> nilai1 + nilai2
                R.id.radioButtonKurang -> nilai1 - nilai2
                R.id.radioButtonKali -> nilai1 * nilai2
                R.id.radioButtonBagi -> {
                    if (nilai2 == 0f) {
                        Toast.makeText(this, "Tidak bisa membagi dengan nol", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    nilai1 / nilai2
                }
                else -> {
                    Toast.makeText(this, "Pilih operasi terlebih dahulu", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(ResultActivity.EXTRA_HASIL, hasil)
            startActivity(intent)
        }
    }
}