package com.example.appmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)

        val button = findViewById<CardView>(R.id.greenHouse1)
        button.setOnClickListener{
            val intent = Intent(this, Details::class.java)
            startActivity(intent)
        }
    }
}