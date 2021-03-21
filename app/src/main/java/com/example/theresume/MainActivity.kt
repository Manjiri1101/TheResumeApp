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

        val workExperience = findViewById<Button>(R.id.workexperiencebutton)
        workExperience.setOnClickListener {
            var moveToWorkExp = Intent(applicationContext, WorkExpActivity2::class.java)
            startActivity(moveToWorkExp)
        }

        val callTab = findViewById<Button>(R.id.call_button)
        callTab.setOnClickListener {
            var phone = Uri.parse("tel:9494495647");
            var callIntent = Intent(Intent.ACTION_DIAL,phone);
            startActivity(callIntent)
        }

        val emailTab = findViewById<Button>(R.id.emailbutton)
        emailTab.setOnClickListener {

            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "Plain/Text"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "manjiri.kadam@sjsu.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Application")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I would like to set-up a call with you, please let us know of your availability")
            startActivity(emailIntent)
        }
//
//        var skillTab = findViewById<Button>(R.id.button5)
//        skillTab.setOnClickListener {
//            var moveToSkill = Intent(getApplicationContext(), Skills2::class.java)
//            startActivity(moveToSkill)
//        }
//
//        var add= findViewById<Button>(R.id.button4)
//        var listV =findViewById<ListView>(R.id.listView)
//        add.setOnClickListener(
//
//        )

        val skillTab = findViewById<Button>(R.id.skillset_button)
        skillTab.setOnClickListener {
            var moveToSkills = Intent(applicationContext, Skills_1::class.java)
            startActivity(moveToSkills)
        }

    }
}