package com.example.tests.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tests.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.tests.storages.PersistantStorage

class MainPage : AppCompatActivity() {

    val auth : FirebaseAuth = FirebaseAuth.getInstance() // запускаем авторизацию
    val db : FirebaseDatabase = FirebaseDatabase.getInstance() // запускаем базу данных
    val users : DatabaseReference = db.getReference("Users") // указываем с какой таблицей работать

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
    }

    fun logout(view: View) {
        val auth : FirebaseAuth = FirebaseAuth.getInstance() // запускаем авторизацию
        val db : FirebaseDatabase = FirebaseDatabase.getInstance() // запускаем базу данных
        val users : DatabaseReference = db.getReference("Users") // указываем с какой таблицей работать

        auth.signOut()
        var storage = PersistantStorage()
        val settings: SharedPreferences = getSharedPreferences(storage.APP_PREFERENCES, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putString("status", "unlogged")
        editor.commit()

        val main_act : Intent = Intent(this, EnterPage::class.java)
        startActivity(main_act)
    }

    override fun onBackPressed(){}

}