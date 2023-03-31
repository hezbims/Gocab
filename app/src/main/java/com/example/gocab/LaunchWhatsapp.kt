package com.example.gocab

import android.content.Context
import android.content.Intent
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import java.net.URL
import java.net.URLEncoder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchWhatsapp @Inject constructor(
    @ApplicationContext private val context : Context
) {
    fun callOjek() =
        context.startActivity(getWhatsappIntent(OJEK_STRING))
    fun callDeliveryMakananBarang() =
        context.startActivity(getWhatsappIntent(DELIVERY_MAKANAN_BARANG_STRING))
    fun callKirimPaket() =
        context.startActivity(getWhatsappIntent(KIRIM_PAKET_STRING))
    fun umkm() =
        context.startActivity(instagramIntent)


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

    private companion object{
        const val KIRIM_PAKET_STRING = """Hai Kakak

Selamat datang di Gocab Delivery.
Pesanan anda akan kami proses, isi format untuk order

Nama pengirim :
Alamat lengkap pengirim :

No hp (aktif) pengirim :


Nama penerima:
Alamat lengkap penerima :

No hp (aktif) penerima:

Spesifikasi barang(jumlah,jenis) :

Apabila ada sharelock maps pengiriman maupun penerima bisa di share yah kak

Terimakasih mohon tunggu Kakak. Kami tunggu juga orderan selanjutnya❤"""



        const val DELIVERY_MAKANAN_BARANG_STRING = """Hai Kakak

Selamat datang di Gocab Delivery.
Pesanan anda akan kami proses, isi format untuk order

- Nama pelanggan :
Alamat lengkap pembelian : 

No hp (aktif) :

 
Alamat pengiriman : 

Spesifikasi barang(jumlah,jenis) : 

Apabila ada sharelock maps pembelian maupun pengiriman bisa di share yah kak

Terimakasih mohon tunggu Kakak. Kami tunggu juga orderan selanjutnya❤"""


        const val OJEK_STRING = """Hai Kakak

Selamat datang di Gocab Delivery.
Pesanan anda akan kami proses, isi format untuk order

- Nama pelanggan :
Alamat lengkap penjemputan(Rt/rw) : 

No hp (aktif) :

 
Alamat tempat tujuan : 

Apabila ada sharelock maps penjemputan maupun tujuan bisa share yah kak


Terimakasih mohon tunggu Kakak. Kami tunggu juga orderan selanjutnya❤"""
    }
}