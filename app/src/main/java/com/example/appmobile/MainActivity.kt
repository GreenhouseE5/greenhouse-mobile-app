package com.example.appmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val button = findViewById<Button>(R.id.login)
        button.setOnClickListener{
            val intent = Intent(this, List::class.java)
            startActivity(intent)
        }
    }
}