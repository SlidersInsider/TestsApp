package com.example.tests.views

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface EnterView: MvpView {
    fun openLogin()
    fun openSignUp()
}