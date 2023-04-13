package com.example.gocab.screen.form_ojek_screen

import androidx.lifecycle.ViewModel
import com.example.gocab.LaunchWhatsapp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FormOjekViewModel @Inject constructor(
    private val launchWhatsapp : LaunchWhatsapp
) : ViewModel() {
    private val _uiState = MutableStateFlow(FormOjekUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event : FormOjekEvent){
        when(event){
            is FormOjekEvent.ChangeNamaPelanggan ->
                _uiState.update { it.copy(namaPelanggan = event.newValue) }
            is FormOjekEvent.ChangeTujuan ->
                _uiState.update { it.copy(tujuan = event.newValue) }
            is FormOjekEvent.ChangeNoWhatsapp ->
                _uiState.update { it.copy(noWhatsapp = event.newValue) }
            is FormOjekEvent.ChangeAlamatPenjemputan ->
                _uiState.update { it.copy(alamatPenjemputan = event.newValue) }
            FormOjekEvent.ClickOrder ->
                uiState.value.apply {
                    launchWhatsapp.callOjek(
                        namaPelanggan = namaPelanggan,
                        alamatPenjemputan = alamatPenjemputan,
                        nomorWhatsapp = noWhatsapp,
                        alamatTujuan = tujuan
                    )
                }
        }
    }
}

data class FormOjekUiState(
    val namaPelanggan : String = "",
    val alamatPenjemputan : String = "",
    val tujuan : String = "",
    val noWhatsapp : String = ""
)

sealed class FormOjekEvent {
    class ChangeNamaPelanggan(val newValue: String) : FormOjekEvent()
    class ChangeAlamatPenjemputan(val newValue : String) : FormOjekEvent()
    class ChangeTujuan(val newValue : String) : FormOjekEvent()
    class ChangeNoWhatsapp(val newValue: String) : FormOjekEvent()
    object ClickOrder : FormOjekEvent()
}