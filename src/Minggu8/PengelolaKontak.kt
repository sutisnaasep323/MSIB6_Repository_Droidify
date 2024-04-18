package Minggu8

data class Kontak(
        val name: String,
        val phoneNumber: String,
        val email: String
)

class PengelolaKontak {
        private val kontakList: MutableList<Kontak> = mutableListOf()

        fun tambahKontak(kontak: Kontak) {
                kontakList.add(kontak)
        }

        fun hapusKontak(kontak: Kontak) {
                kontakList.remove(kontak)
        }

        fun tampilkanKontak() {
                for (kontak in kontakList) {
                        println("${kontak.name}, ${kontak.phoneNumber}, ${kontak.email}")
                }
        }
}

fun main() {
        val kontak1 = Kontak("John Doe", "12345678", "john.doe@example.com")
        val kontak2 = Kontak("Jane Doe", "87654321", "jane.doe@example.com")

        val pengelolaKontak = PengelolaKontak()

        pengelolaKontak.tambahKontak(kontak1)
        pengelolaKontak.tambahKontak(kontak2)

        pengelolaKontak.tampilkanKontak()

        pengelolaKontak.hapusKontak(kontak1)

        pengelolaKontak.tampilkanKontak()
}