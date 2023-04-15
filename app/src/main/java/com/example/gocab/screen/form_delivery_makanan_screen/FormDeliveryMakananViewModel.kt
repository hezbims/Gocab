package com.example.gocab.screen.form_delivery_makanan_screen

import androidx.lifecycle.ViewModel
import com.example.gocab.LaunchWhatsapp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FormDeliveryMakananViewModel @Inject constructor(
    private val launchWhatsapp : LaunchWhatsapp
) : ViewModel() {
    private val _uiState = MutableStateFlow(FormDeliveryMakananUiState())
    val uiState = _uiState.asStateFlow()


    fun onEvent(event : FormDeliveryMakananEvent){
        when(event){
            is FormDeliveryMakananEvent.ChangeNamaPelanggan ->
                _uiState.update { it.copy(namaPelanggan = event.newValue) }
            is FormDeliveryMakananEvent.ChangeAlamatPembelian ->
                _uiState.update { it.copy(alamatPembelian = event.newValue) }
            is FormDeliveryMakananEvent.ChangeDetailOrderan ->
                _uiState.update { it.copy(detailOrderan = event.newValue) }
            is FormDeliveryMakananEvent.ChangeNoWhatsapp ->
                _uiState.update { it.copy(noWhatsapp = event.newValue) }
            is FormDeliveryMakananEvent.ChangeAlamatPengantaran ->
                _uiState.update { it.copy(alamatPengantaran = event.newValue) }
            FormDeliveryMakananEvent.ClickOrder ->
                _uiState.value.apply {
                    launchWhatsapp.callDeliveryMakanan(
                        alamatPengantaran = alamatPengantaran,
                        alamatPembelian = alamatPembelian,
                        detailOrderan = detailOrderan,
                        namaPelanggan = namaPelanggan,
                        noWhatsapp = noWhatsapp
                    )
                }
        }
    }
}

data class FormDeliveryMakananUiState(
    val namaPelanggan : String = "",
    val alamatPembelian : String = "",
    val alamatPengantaran : String = "",
    val detailOrderan : String = "",
    val noWhatsapp : String = ""
)

sealed class FormDeliveryMakananEvent{
    class ChangeNamaPelanggan(val newValue : String) : FormDeliveryMakananEvent()
    class ChangeAlamatPembelian(val newValue : String) : FormDeliveryMakananEvent()
    class ChangeAlamatPengantaran(val newValue : String) : FormDeliveryMakananEvent()
    class ChangeDetailOrderan(val newValue: String) : FormDeliveryMakananEvent()
    class ChangeNoWhatsapp(val newValue : String) : FormDeliveryMakananEvent()
    object ClickOrder : FormDeliveryMakananEvent()
}

