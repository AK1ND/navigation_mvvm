package com.alex_kind.navigation_mvvm.screens.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex_kind.navigation_mvvm.Event
import com.alex_kind.navigation_mvvm.R
import com.alex_kind.navigation_mvvm.navigator.Navigator
import com.alex_kind.navigation_mvvm.screens.base.BaseViewModel

class EditViewModel(
    private val navigator: Navigator,
    screen: EditFragment.Screen
): BaseViewModel() {


    private val _initialMessageEvent = MutableLiveData<Event<String>>()
    val initialMessageEvent: LiveData<Event<String>> = _initialMessageEvent

    init {
        _initialMessageEvent.value = Event(screen.initialValue)

    }


    fun onSavePressed(message: String){
        if (message.isBlank()){
            navigator.toast(R.string.empty_message)
            return
        }
        navigator.goBack(message)
    }

    fun onCancelPressed(){
        navigator.goBack()
    }


}