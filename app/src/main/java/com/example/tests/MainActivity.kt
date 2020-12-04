package com.example.tests

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login_activity(view: View) {
        val act : Intent = Intent(this, LoginPage::class.java)
        startActivity(act)
    }
    fun signup_activity(view: View) {
        val act : Intent = Intent(this, SignUpPage::class.java)
        startActivity(act)
    }
}