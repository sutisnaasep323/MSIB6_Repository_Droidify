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

        suspend fun tampilkanDaftarCatatanAsync(): List<Catatan> = coroutineScope {
                return@coroutineScope async {
                        delay(1000) // Simulasi operasi async (contoh: pemrosesan jaringan atau database)
                        return@async daftarCatatan
                }.await()
        }
}

suspend fun main() {
        val app = AppCatatanSederhana()
        app.tambahCatatan(Catatan("Note 1", "This is note 1"))
        app.tambahCatatan(Catatan("Note 2", "This is note 2"))

        // Menggunakan coroutine untuk menampilkan daftar catatan secara asynchronous
        val daftarCatatan = app.tampilkanDaftarCatatanAsync()
        println("Menampilkan daftar catatan secara asynchronous...")
        daftarCatatan.forEachIndexed { index, catatan ->
                println("${index + 1}. ${catatan.judul} - ${catatan.konten}")
        }
}