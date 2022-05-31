package com.alex_kind.navigation_mvvm.screens.base

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alex_kind.navigation_mvvm.navigator.ARG_SCREEN
import com.alex_kind.navigation_mvvm.navigator.MainNavigator
import com.alex_kind.navigation_mvvm.navigator.Navigator

class ViewModelFactory(
    private val screen: BaseScreen,
    private val fragment: BaseFragment
): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val hostActivity = fragment.requireActivity()
        val application = hostActivity.application
        val navigatorProvider = ViewModelProvider(hostActivity, ViewModelProvider.AndroidViewModelFactory(application))
        val navigator = navigatorProvider[MainNavigator::class.java]

        val constructor = modelClass.getConstructor(Navigator::class.java, screen::class.java)
        return constructor.newInstance(navigator, screen)

    }

}

inline fun <reified VM: ViewModel> BaseFragment.screenViewModel() = viewModels<VM> {
    val screen = requireArguments().getSerializable(ARG_SCREEN) as BaseScreen
    ViewModelFactory(screen, this)
}