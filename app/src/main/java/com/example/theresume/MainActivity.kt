package com.example.theresume

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var workExperience = findViewById<Button>(R.id.button)
        workExperience.setOnClickListener {
        var moveToWorkExp = Intent(getApplicationContext(), WorkExpActivity2::class.java)
        startActivity(moveToWorkExp)
        }

        var callTab = findViewById<Button>(R.id.button2)
        callTab.setOnClickListener {
            var phone =Uri.parse("tel:9494495647");
            var callIntent = Intent(Intent.ACTION_DIAL,phone);
            startActivity(callIntent)
        }

        var emailTab = findViewById<Button>(R.id.button3)
        emailTab.setOnClickListener {

            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("Plain/Text")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "manjiri.kadam@sjsu.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Application")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I would like to set-up a call with you, please let us know of your availablity")
            startActivity(emailIntent)
        }

        var skillTab = findViewById<Button>(R.id.button5)
        skillTab.setOnClickListener {
            var moveToSkill = Intent(getApplicationContext(), Skills2::class.java)
            startActivity(moveToSkill)
        }

    }
}