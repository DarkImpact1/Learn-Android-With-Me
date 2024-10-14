package com.example.learning_as

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ImplicitIntentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        val btnDial = findViewById<Button>(R.id.btnDial)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnMessage = findViewById<Button>(R.id.btnMessage)
        val btnShare = findViewById<Button>(R.id.btnShare)
        val btnExplicit = findViewById<Button>(R.id.btnExplicit)


        // Dial button functionality
        btnDial.setOnClickListener {
            val phoneNumber = "tel:1234567890"
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse(phoneNumber)
            startActivity(dialIntent)
        }

        // Email button functionality
        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:example@example.com")
            startActivity(emailIntent)

        }

        // Message button functionality
        btnMessage.setOnClickListener {
            val messageIntent = Intent(Intent.ACTION_SENDTO)
            messageIntent.data = Uri.parse("smsto:1234567890")
            messageIntent.putExtra("sms_body", "Hello, this is a test message!")
            startActivity(messageIntent)
        }

// Share button functionality
        btnShare.setOnClickListener {
            val shareText = "Hello, this is a text to share!"
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }

            val chooser = Intent.createChooser(shareIntent, "Share using")
            startActivity(chooser)

        }


        btnExplicit.setOnClickListener{
            val implicit = Intent(this,RegistrationActivity::class.java)
            startActivity(implicit)
            finish()
        }
    }
}
