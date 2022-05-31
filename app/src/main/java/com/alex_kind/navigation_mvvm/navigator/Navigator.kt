package com.alex_kind.navigation_mvvm.navigator

import androidx.annotation.StringRes
import com.alex_kind.navigation_mvvm.screens.base.BaseScreen

interface Navigator {
    fun launch(screen: BaseScreen)

    fun goBack(result: Any? = null)

    fun toast(@StringRes messageRes: Int)

    fun getString(@StringRes messageRes: Int): String
}