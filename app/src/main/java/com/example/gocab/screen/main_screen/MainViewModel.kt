package com.example.gocab.screen.main_screen

import androidx.lifecycle.ViewModel
import com.example.gocab.LaunchWhatsapp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val launchWhatsapp: LaunchWhatsapp
) : ViewModel(){
    fun onEvent(
        event: MainScreenEvent
    ){
        when(event){
            MainScreenEvent.Umkm -> launchWhatsapp.umkm()
        }
    }
}

sealed class MainScreenEvent{
    object Umkm : MainScreenEvent()
}