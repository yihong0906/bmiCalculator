package com.example.weightcalculation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.enterButton)

        button.setOnClickListener {
            val sampleData =findViewById<TextView>(R.id.enterNametxt)
            val intent = Intent(this@MainActivity, calculateWeight::class.java)
            intent.putExtra("personName",sampleData.text.toString())
            startActivity(intent)
        }
    }
}