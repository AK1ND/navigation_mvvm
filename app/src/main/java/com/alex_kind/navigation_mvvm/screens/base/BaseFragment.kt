package com.alex_kind.navigation_mvvm.screens.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract val viewModel: BaseViewModel

}