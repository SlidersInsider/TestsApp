package com.example.tests.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tests.storages.PersistantStorage


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var storage = PersistantStorage()
        val settings: SharedPreferences = getSharedPreferences(storage.APP_PREFERENCES, Context.MODE_PRIVATE)
        var res = settings.getString("status", "logged")

        if(res == "logged"){
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
            finish()
        }
        else{
            val intent = Intent(this, EnterPage::class.java)
            startActivity(intent)
            finish()
        }


    }
}