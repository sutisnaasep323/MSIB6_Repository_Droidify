package Minggu8

import java.util.Scanner

data class Kontak(
        val name: String,
        val phoneNumber: String,
        val email: String
)

class PengelolaKontak {
        private val kontakList: MutableList<Kontak> = mutableListOf()

        fun tambahKontak(kontak: Kontak) {
                kontakList.add(kontak)
                println("Kontak '${kontak.name}' berhasil ditambahkan.")
        }

        fun hapusKontak(namaKontak: String) {
                val kontakDitemukan = kontakList.find { it.name == namaKontak }
                if (kontakDitemukan != null) {
                        kontakList.remove(kontakDitemukan)
                        println("Kontak '$namaKontak' berhasil dihapus.")
                } else {
                        println("Kontak '$namaKontak' tidak ditemukan.")
                }
        }

        fun tampilkanKontak() {
                if (kontakList.isEmpty()) {
                        println("Daftar kontak kosong.")
                } else {
                        println("Daftar Kontak:")
                        kontakList.forEachIndexed { index, kontak ->
                                println("${index + 1}. ${kontak.name}, ${kontak.phoneNumber}, ${kontak.email}")
                        }
                }
        }
}

fun main() {
        val scanner = Scanner(System.`in`)
        val pengelolaKontak = PengelolaKontak()

        println("Selamat datang di Pengelola Kontak!")

        var isRunning = true
        while (isRunning) {
                println("""
            Pilih operasi yang ingin dilakukan:
            1. Tambah Kontak
            2. Hapus Kontak
            3. Tampilkan Kontak
            4. Keluar
        """.trimIndent())

                print("Masukkan pilihan (1/2/3/4): ")
                when (scanner.nextInt()) {
                        1 -> {
                                print("Masukkan nama kontak: ")
                                val name = scanner.next()
                                print("Masukkan nomor telepon: ")
                                val phoneNumber = scanner.next()
                                print("Masukkan alamat email: ")
                                val email = scanner.next()
                                val kontak = Kontak(name, phoneNumber, email)
                                pengelolaKontak.tambahKontak(kontak)
                        }
                        2 -> {
                                print("Masukkan nama kontak yang ingin dihapus: ")
                                val namaKontak = scanner.next()
                                pengelolaKontak.hapusKontak(namaKontak)
                        }
                        3 -> {
                                pengelolaKontak.tampilkanKontak()
                        }
                        4 -> {
                                println("Terima kasih!")
                                isRunning = false
                        }
                        else -> {
                                println("Pilihan tidak valid. Silakan pilih 1, 2, 3, atau 4.")
                        }
                }
        }
        scanner.close()
}
