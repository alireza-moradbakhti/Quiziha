package com.example.quiziha.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quiziha.framework.Event
import com.example.quiziha.framework.OnClickEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _event = MutableLiveData<Event<OnClickEvent>>()
    val event: LiveData<Event<OnClickEvent>> = _event


    fun onBackClick() {
        _event.postValue(Event(OnClickEvent.Back()))
    }
}