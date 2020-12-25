package com.example.tests.activities

import android.content.Intent
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tests.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.tests.storages.PersistantStorage

class LoginPage : AppCompatActivity() {

    val auth : FirebaseAuth = FirebaseAuth.getInstance() // запускаем авторизацию
    val db : FirebaseDatabase = FirebaseDatabase.getInstance()// запускаем базу данных
    val users : DatabaseReference = db.getReference("Users")// указываем с какой таблицей работать

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
    }

    fun login(view: View) {
        val email : EditText = findViewById(R.id.email_text2)
        val password : EditText = findViewById(R.id.password_text3)

        val email_str : String = email.text.toString()
        val password_str : String = password.text.toString()

        if (TextUtils.isEmpty(email_str)){
            Snackbar.make(findViewById(R.id.login_layout),"Enter yours login!", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (password_str.length < 8){
            Snackbar.make(findViewById(R.id.login_layout),"Enter yours password!", Snackbar.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword(email_str, password_str)
        var storage = PersistantStorage()
        val settings: SharedPreferences = getSharedPreferences(storage.APP_PREFERENCES, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putString("status", "logged")
        editor.commit()


        val main_page_act : Intent = Intent(this, MainPage::class.java)
        startActivity(main_page_act)
        

    }
}