package Minggu7

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
