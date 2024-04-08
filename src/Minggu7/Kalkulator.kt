package Minggu7

import java.util.*

class Kalkulator {
    fun tambah(a: Int, b: Int): Int {
        return a + b
    }

    fun kurang(a: Int, b: Int): Int {
        return a - b
    }

    fun kali(a: Int, b: Int): Int {
        return a * b
    }

    fun bagi(a: Int, b: Int): Double {
        if (b == 0) {
            throw ArithmeticException("Tidak dapat membagi dengan nol")
        }
        return a.toDouble() / b.toDouble()
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val kalkulator = Kalkulator()

    var pilihan = 0
    while (pilihan != 5) {

        println("===[ Kalkulator Tim Droidify ]====")

        print("Masukkan angka pertama: ")
        val angka1 = scanner.nextInt()
        print("Masukkan angka kedua: ")
        val angka2 = scanner.nextInt()

        println("\nPilih Operasi Matematika:")
        println("1. Tambah")
        println("2. Kurang")
        println("3. Kali")
        println("4. Bagi")
        println("5. Keluar")
        print("Masukkan pilihan Anda: ")

        pilihan = scanner.nextInt()

        if (pilihan == 1) {
            val hasil = kalkulator.tambah(angka1, angka2)
            println("Hasil penjumlahan: $hasil")
        } else if (pilihan == 2) {
            val hasil = kalkulator.kurang(angka1, angka2)
            println("Hasil pengurangan: $hasil")
        } else if (pilihan == 3) {
            val hasil = kalkulator.kali(angka1, angka2)
            println("Hasil perkalian: $hasil")
        } else if (pilihan == 4) {
            val hasil = kalkulator.bagi(angka1, angka2)
            println("Hasil pembagian: $hasil")
        } else if (pilihan == 5) {
            println("Terima kasih telah menggunakan kalkulator.")
        } else {
            println("Pilihan tidak valid.")
        }
        println()
    }
}