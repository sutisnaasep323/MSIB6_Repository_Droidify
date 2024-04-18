package Minggu8

import java.util.Scanner

data class Kontak(
        private val name: String,
        private val phoneNumber: String,
        private val email: String
) {
    fun getName(): String {
        return name
    }

    fun getPhoneNumber(): String {
        return phoneNumber
    }

    fun getEmail(): String {
        return email
    }
}

class PengelolaKontak {
    private val kontakList: MutableList<Kontak> = mutableListOf()

    //Atribut kontakList tetap private karena ini merupakan struktur data internal dari kelas PengelolaKontak dan tidak seharusnya diakses langsung dari luar
    // untuk (tambahKontak, hapusKontak, tampilkanKontak) metode publik karena memang seharusnya bisa diakses dari luar kelas tersebut.
    fun tambahKontak(kontak: Kontak) {
        kontakList.add(kontak)
        println("Kontak '${kontak.getName()}' berhasil ditambahkan.")
    }

    fun hapusKontak(namaKontak: String) {
        val kontakDitemukan = kontakList.find { it.getName() == namaKontak }
        if (kontakDitemukan != null) {
            kontakList.remove(kontakDitemukan)
            println("Kontak '$namaKontak' berhasil dihapus.")
        } else {
            println("Kontak '$namaKontak' tidak ditemukan.")
        }
    }

    fun Kontak.printContactInfo() {
        println("Nama: ${getName()}, Nomor Telepon: ${getPhoneNumber()}, Email: ${getEmail()}")
    }


    fun tampilkanKontak() {
        if (kontakList.isEmpty()) {
            println("Daftar kontak kosong.")
        } else {
            println("Daftar Kontak:")
            kontakList.forEachIndexed { index, kontak ->
                print("${index + 1}. ")
                kontak.printContactInfo()
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
                pengelolaKontak.tampilkanKontak()
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
