package com.example.weightcalculation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class calculateWeight : AppCompatActivity() {

    var bmiIndex : Double =0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_weight)

        val tvname = findViewById<TextView>(R.id.welcome)
        val personName = intent?.getStringExtra("personName")
        tvname.setText(personName)

        if(savedInstanceState!=null)
        {
           bmiIndex = savedInstanceState.getDouble("bmi")
            val tvStatus = findViewById<TextView>(R.id.statusTxt)
            tvStatus.setText(getStatus())
        }

        val btnCal = findViewById<Button>(R.id.buttonEnter2)
        btnCal.setOnClickListener() {
            val weightVar = findViewById<TextView>(R.id.weightTxt).text.toString()
            val heightVar = findViewById<TextView>(R.id.HeightTxt).text.toString()
           bmiIndex= weightVar.toDouble() / (heightVar.toDouble() * heightVar.toDouble())

            val tvStatus = findViewById<TextView>(R.id.statusTxt)
            tvStatus.setText(getStatus())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmi",bmiIndex)
    }
    private fun getStatus():String{
        if(bmiIndex<18.5)
            return "Underweight"
        else if(bmiIndex <=24.9)
            return "Normal Weight"
        else if(bmiIndex <=29.9)
            return "overweight"
        else if(bmiIndex <=34.9)
            return "Obesity Class I"
        else if(bmiIndex <=39.9)
            return "Obesity Class II"
        else
            return "Obesity Class III"
    }
}