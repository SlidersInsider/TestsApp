package com.example.tests.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.tests.presenters.EnterPresenter
import com.example.tests.R
import com.example.tests.views.EnterView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class EnterPage : MvpAppCompatActivity(), EnterView {

    lateinit var btnLoginPage: Button
    lateinit var btnSignUpPage: Button

    @InjectPresenter
    lateinit var enterPresenter: EnterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoginPage = findViewById(R.id.login_btn)
        btnSignUpPage = findViewById(R.id.signup_btn)

        btnLoginPage.setOnClickListener {
            enterPresenter.goToLoginPage()
        }

        btnSignUpPage.setOnClickListener {
            enterPresenter.goToSignUpPage()
        }
    }

    override fun openLogin() {
        startActivity(Intent(applicationContext, LoginPage::class.java))
    }

    override fun openSignUp() {
        startActivity(Intent(applicationContext, SignUpPage::class.java))
    }
}