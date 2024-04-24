package Minggu9

import kotlinx.coroutines.*

data class Catatan(
        val judul: String,
        val konten: String
)

class AppCatatanSederhana {
    private val daftarCatatan: MutableList<Catatan> = mutableListOf()

    fun tambahCatatan(catatan: Catatan) {
        daftarCatatan.add(catatan)
        println("Catatan '${catatan.judul}' berhasil ditambahkan.")
    }

    fun tampilkanDaftarCatatan() {
        if (daftarCatatan.isEmpty()) {
            println("Daftar catatan kosong.")
        } else {
            println("Daftar Catatan:")
            daftarCatatan.forEachIndexed { index, catatan ->
                println("${index + 1}. ${catatan.judul} - ${catatan.konten}")
            }
        }
    }
}

suspend fun main() {
    //...
}