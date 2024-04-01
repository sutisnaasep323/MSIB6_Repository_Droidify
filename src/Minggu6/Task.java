package Minggu6;

public class Task {
    private String judul;
    private String deskripsi;

    public Task(String judul, String deskripsi) {
        this.judul = judul;
        this.deskripsi = deskripsi;
    }

    public String getJudul() {
        return judul;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Deskripsi: " + deskripsi;
    }

}