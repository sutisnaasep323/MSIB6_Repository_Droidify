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
        val pengelolaCatatan = AppCatatanSederhana()

        println("Selamat datang di Aplikasi Catatan Sederhana!")

        var isRunning = true
        while (isRunning) {
                println("""
                    Pilih operasi yang ingin dilakukan:
                    1. Tambah Catatan
                    2. Tampilkan Daftar Catatan
                    3. Keluar
                """.trimIndent())

                print("Masukkan pilihan (1/2/3): ")
                when (readLine()?.toIntOrNull()) {
                        1 -> {
                                print("Masukkan judul catatan: ")
                                val judul = readLine().toString()
                                print("Masukkan konten catatan: ")
                                val konten = readLine().toString()
                                val catatan = Catatan(judul, konten)
                                pengelolaCatatan.tambahCatatan(catatan)
                        }
                        2 -> {
                                println("Menampilkan daftar catatan...")
                                try {
                                        coroutineScope {
                                                pengelolaCatatan.tampilkanDaftarCatatan()
                                        }
                                } catch (e: Exception) {
                                        println("Terjadi kesalahan saat menampilkan daftar catatan: ${e.message}")
                                }
                        }
                        3 -> {
                                println("Terima kasih!")
                                isRunning = false
                        }
                        else -> {
                                println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.")
                        }
                }
        }
}