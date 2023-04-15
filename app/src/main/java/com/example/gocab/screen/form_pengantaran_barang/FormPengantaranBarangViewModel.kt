package com.example.gocab.screen.form_pengantaran_barang

import androidx.lifecycle.ViewModel
import com.example.gocab.LaunchWhatsapp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FormPengantaranBarangViewModel @Inject constructor(
    private val launchWhatsapp: LaunchWhatsapp
): ViewModel() {
    private val _uiState = MutableStateFlow(FormPengantaranBarangUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event : FormPengantaranBarangEvent){
        when(event){
            is FormPengantaranBarangEvent.ChangeNamaPengirim ->
                _uiState.update { it.copy(namaPengirim = event.newValue) }
            is FormPengantaranBarangEvent.ChangeAlamatPengambilan ->
                _uiState.update { it.copy(alamatPengambilan = event.newValue) }
            is FormPengantaranBarangEvent.ChangeNoWhatsappPengirim ->
                _uiState.update { it.copy(noWhatsappPengirim = event.newValue) }
            is FormPengantaranBarangEvent.ChangeNamaPenerima ->
                _uiState.update { it.copy(namaPenerima = event.newValue) }
            is FormPengantaranBarangEvent.ChangeAlamatPengantaran ->
                _uiState.update { it.copy(alamatPengantaran = event.newValue) }
            is FormPengantaranBarangEvent.ChangeNoWhatsappPenerima ->
                _uiState.update { it.copy(noWhatsappPenerima = event.newValue) }
            is FormPengantaranBarangEvent.ChangeDetailPaket ->
                _uiState.update { it.copy(detailPaket = event.newValue) }
            FormPengantaranBarangEvent.ClickOrder ->
                _uiState.value.apply {
                    launchWhatsapp.callKirimPaket(
                        namaPengirim = namaPengirim,
                        alamatPengambilan = alamatPengambilan,
                        noWhatsappPengirim = noWhatsappPengirim,
                        namaPenerima = namaPenerima,
                        alamatPengantaran = alamatPengantaran,
                        noWhatsappPenerima = noWhatsappPenerima,
                        detailPaket = detailPaket
                    )
                }
        }
    }
}

data class FormPengantaranBarangUiState(
    val namaPengirim : String =  "",
    val alamatPengambilan : String =  "",
    val noWhatsappPengirim : String =  "",
    val namaPenerima : String =  "",
    val alamatPengantaran : String =  "",
    val noWhatsappPenerima : String =  "",
    val detailPaket : String =  ""
)

sealed class FormPengantaranBarangEvent{
    class ChangeNamaPengirim(val newValue : String) : FormPengantaranBarangEvent()
    class ChangeAlamatPengambilan(val newValue: String) : FormPengantaranBarangEvent()
    class ChangeNoWhatsappPengirim(val newValue : String) : FormPengantaranBarangEvent()
    class ChangeNamaPenerima(val newValue : String) : FormPengantaranBarangEvent()
    class ChangeAlamatPengantaran(val newValue : String) : FormPengantaranBarangEvent()
    class ChangeNoWhatsappPenerima(val newValue : String) : FormPengantaranBarangEvent()
    class ChangeDetailPaket(val newValue: String) : FormPengantaranBarangEvent()
    object ClickOrder : FormPengantaranBarangEvent()
}