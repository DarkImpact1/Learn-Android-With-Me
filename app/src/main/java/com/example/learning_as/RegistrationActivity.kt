package com.example.learning_as

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RegistrationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etRegisterEmail)
        val etPassword = findViewById<EditText>(R.id.etRegisterPassword)
        val etCnfPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnLogin = findViewById<Button>(R.id.registerLogin)
        val btnImplicit = findViewById<Button>(R.id.btnimplicit)


        // OnClickListener for the Register Button
        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val cnfPassword = etCnfPassword.text.toString().trim()


            // Validate inputs
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {


                if(validatePassword(password,cnfPassword)) {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                    // Create intent to pass data to LoginActivity
                    val intent = Intent(this, LoginActivity::class.java)
                    // Pass data via Intent
                    intent.putExtra("email", email)
                    intent.putExtra("password", password)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this,"Password mismatched",Toast.LENGTH_SHORT).show()
                }
            }
        }

        // OnClickListener for the Login link text to go to LoginActivity
        btnLogin.setOnClickListener {
            val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnImplicit.setOnClickListener{
            val implicit = Intent(this,ImplicitIntentActivity::class.java)
            startActivity(implicit)
            finish()
        }
    }
    private fun validatePassword(pass1:String, pass2 :String): Boolean {
        return pass1 == pass2
    }

}
