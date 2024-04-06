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

fun main() {
    val calculator = Kalkulator()

    println("Selamat datang di kalkulator sederhana!")
    println("Masukkan operasi matematika (tambah, kurang, kali, atau bagi):")

    // Keep asking for user input until they type "keluar"
    while (true) {
        print("> ")
        val input = readLine()

        if (input == "keluar") {
            println("Terima kasih telah menggunakan kalkulator sederhana ini.")
            break
        }

        val parts = input?.split(" ") ?: continue
        if (parts.size != 3) {
            println("Mohon masukkan format yang benar: operasi bilangan1 bilangan2")
            continue
        }

        val operation = parts[0]
        val num1 = parts[1].toIntOrNull()
        val num2 = parts[2].toIntOrNull()

        if (num1 == null || num2 == null) {
            println("Mohon masukkan bilangan bulat yang valid.")
            continue
        }

        var result: Any? = null
        try {
            when (operation.toLowerCase()) {
                "tambah" -> result = calculator.tambah(num1, num2)
                "kurang" -> result = calculator.kurang(num1, num2)
                "kali" -> result = calculator.kali(num1, num2)
                "bagi" -> result = calculator.bagi(num1, num2)
                else -> println("Mohon masukkan operasi matematika yang valid.")
            }
        } catch (e: ArithmeticException) {
            println(e.message)
            continue
        }

        println("Hasil: $result")
    }
}
