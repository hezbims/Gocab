package com.example.gocab

import android.content.Context
import android.content.Intent
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import java.net.URLEncoder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchWhatsapp @Inject constructor(
    @ApplicationContext private val context : Context
) {
    fun umkm() =
        context.startActivity(instagramIntent)

    fun callOjek(
        namaPelanggan : String,
        alamatPenjemputan : String,
        nomorWhatsapp : String,
        alamatTujuan : String,
    ){
        context.startActivity(
            getWhatsappIntent(
                message = formatOjekString(
                    namaPelanggan = namaPelanggan,
                    alamatPenjemputan = alamatPenjemputan,
                    nomorWhatsapp = nomorWhatsapp,
                    alamatTujuan = alamatTujuan
                )
            )
        )
    }

    private fun formatOjekString(
        namaPelanggan: String,
        alamatPenjemputan: String,
        nomorWhatsapp: String,
        alamatTujuan: String,
    ) : String{
        return context.getString(
            R.string.wa_text_ojek,
            namaPelanggan,
            alamatPenjemputan,
            nomorWhatsapp,
            alamatTujuan
        )
    }

    fun callDeliveryMakanan(
        namaPelanggan: String,
        alamatPembelian : String,
        alamatPengantaran : String,
        detailOrderan : String,
        noWhatsapp : String
    ){
        context.startActivity(
            getWhatsappIntent(
                message = formatDeliveryMakananString(
                    namaPelanggan = namaPelanggan,
                    alamatPembelian = alamatPembelian,
                    alamatPengantaran = alamatPengantaran,
                    detailOrderan = detailOrderan,
                    nomorWhatsapp = noWhatsapp
                )
            )
        )
    }

    private fun formatDeliveryMakananString(
        namaPelanggan: String,
        alamatPembelian: String,
        alamatPengantaran: String,
        detailOrderan: String,
        nomorWhatsapp: String
    ) : String{
        return context.getString(
            R.string.wa_text_delivery_makanan,
            namaPelanggan,
            alamatPembelian,
            alamatPengantaran,
            detailOrderan,
            nomorWhatsapp
        )
    }

    fun callKirimPaket(
        namaPengirim : String,
        alamatPengambilan : String,
        noWhatsappPengirim : String,
        namaPenerima : String,
        alamatPengantaran : String,
        noWhatsappPenerima : String,
        detailPaket : String
    ){
        context.startActivity(
            getWhatsappIntent(
                message = context.getString(
                    R.string.wa_text_pengantaran_paket,
                    namaPengirim,
                    alamatPengambilan,
                    noWhatsappPengirim,
                    namaPenerima,
                    alamatPengantaran,
                    noWhatsappPenerima,
                    detailPaket
                )
            )
        )
    }


    private fun getWhatsappIntent(message : String) =
        Intent(Intent.ACTION_VIEW).apply {
            `package` = "com.whatsapp"
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
            val uri = Uri.parse(
                "https://api.whatsapp.com/send?phone=6289521763802&text=" +
                        URLEncoder.encode(message , "UTF-8")
            )

            data = uri
        }

    private val instagramIntent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(
            "https://instagram.com/gocab_delivery?igshid=YmMyMTA2M2Y="
        )
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
    }

}