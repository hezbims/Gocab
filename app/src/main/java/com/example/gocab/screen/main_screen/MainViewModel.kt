package com.example.gocab

import androidx.lifecycle.ViewModel
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
            MainScreenEvent.CallOjek -> launchWhatsapp.callOjek()
            MainScreenEvent.CallDeliveryMakananBarang -> launchWhatsapp.callDeliveryMakananBarang()
            MainScreenEvent.CallKirimPaket -> launchWhatsapp.callKirimPaket()
            MainScreenEvent.Umkm -> launchWhatsapp.umkm()
        }
    }
}

sealed class MainScreenEvent{
    object CallOjek : MainScreenEvent()
    object CallDeliveryMakananBarang : MainScreenEvent()
    object CallKirimPaket : MainScreenEvent()
    object Umkm : MainScreenEvent()
}