package com.example.tests.presenters

import com.example.tests.views.EnterView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class EnterPresenter: MvpPresenter<EnterView>() {
    fun goToLoginPage() {
        viewState.openLogin()
    }

    fun goToSignUpPage() {
        viewState.openSignUp()
    }
}