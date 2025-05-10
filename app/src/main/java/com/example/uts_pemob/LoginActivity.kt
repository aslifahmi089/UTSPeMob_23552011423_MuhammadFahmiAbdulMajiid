package com.example.uts_pemob

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    val PREF_NAME = "user_pref"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.etEmail)
        val passwordInput = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnToRegister = findViewById<Button>(R.id.btnToRegister)
        val btnBack = findViewById<Button>(R.id.btnBack)

        preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val savedEmail = preferences.getString("email", "")
            val savedPass = preferences.getString("password", "")

            val inputEmail = emailInput.text.toString()
            val inputPass = passwordInput.text.toString()

            if (inputEmail == savedEmail && inputPass == savedPass) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ListChatActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        btnToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
