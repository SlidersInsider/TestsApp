package com.example.tests.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import com.example.tests.models.User
import com.example.tests.R
import com.example.tests.storages.PersistantStorage
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignUpPage : AppCompatActivity() {

    val auth : FirebaseAuth = FirebaseAuth.getInstance() // запускаем авторизацию
    val db : FirebaseDatabase = FirebaseDatabase.getInstance() // запускаем базу данных
    val users : DatabaseReference = db.getReference("Users") // указываем с какой таблицей работать

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)
    }

    fun signUp(view: View) {
        val email : EditText = findViewById(R.id.email_text)
        val login : EditText = findViewById(R.id.login_text)
        val password : EditText = findViewById(R.id.password_text)
        val check_password : EditText = findViewById(R.id.password_text2)

        val email_str : String = email.text.toString()
        val login_str : String = login.text.toString()
        val password_str : String = password.text.toString()
        val check_password_str : String = check_password.text.toString()

        if (TextUtils.isEmpty(email_str)){
            Snackbar.make(findViewById(R.id.signup_layout),"Enter yours email!", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(login_str)){
            Snackbar.make(findViewById(R.id.signup_layout),"Enter yours login!", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (password_str.length < 8){
            Snackbar.make(findViewById(R.id.signup_layout),"Enter yours password!", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (check_password_str.length < 8){
            Snackbar.make(findViewById(R.id.signup_layout),"Enter yours password!", Snackbar.LENGTH_SHORT).show()
            return
        }
        if (!password_str.equals(check_password_str, true)){
            Snackbar.make(findViewById(R.id.signup_layout),"Enter equals password!", Snackbar.LENGTH_SHORT).show()
            return
        }
        val user : User = User(email_str, login_str, password_str)

        auth.createUserWithEmailAndPassword(email_str, password_str)
        users.child(user.login).setValue(user)

        var storage = PersistantStorage()
        val settings: SharedPreferences = getSharedPreferences(storage.APP_PREFERENCES, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putString("status", "logged")
        editor.commit()

        val main_page_act : Intent = Intent(this, MainPage::class.java)
        startActivity(main_page_act)

    }
}