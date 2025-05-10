package com.example.uts_pemob

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    val PREF_NAME = "user_pref"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailInput = findViewById<EditText>(R.id.etEmail)
        val passInput = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnBack = findViewById<Button>(R.id.btnBack)

        preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val email = emailInput.text.toString()
            val pass = passInput.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                preferences.edit().apply {
                    putString("email", email)
                    putString("password", pass)
                    apply()
                }
                Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
