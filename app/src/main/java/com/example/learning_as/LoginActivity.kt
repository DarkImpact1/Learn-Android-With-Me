package com.example.learning_as

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.loginRegister)

        // Get data passed from RegistrationActivity
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        // Pre-fill email and password if passed
        if (email != null) etEmail.setText(email)
        if (password != null) etPassword.setText(password)

        btnRegister.setOnClickListener{
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
