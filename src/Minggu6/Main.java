package Minggu6;

import java.util.*;

public class Main {

    private List<Task> tasks;
    private Scanner scanner;

    public Main() {
        scanner = new Scanner(System.in);
        tasks = new LinkedList<>(); // Default adalah LinkedList
    }

    private void selectDataStructure() {
        System.out.println("Pilih struktur data untuk penyimpanan tugas:");
        System.out.println("1. LinkedList");
        System.out.println("2. Stack");
        System.out.println("3. Queue");
        System.out.print("Pilihan Anda (1/2/3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                tasks = new LinkedList<>();
                break;
            case 2:
                tasks = new Stack<>();
                break;
            case 3:
                tasks = new LinkedList<>(); // Queue implementation via LinkedList
                break;
            default:
                System.out.println("Pilihan tidak valid. Menggunakan LinkedList.");
                tasks = new LinkedList<>();
        }
    }

    private void addTask() {
        System.out.print("Masukkan judul tugas: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan deskripsi tugas: ");
        String deskripsi = scanner.nextLine();

        tasks.add(new Task(judul, deskripsi));
        System.out.println("Tugas berhasil ditambahkan.");
    }

    private void removeTask() {
        System.out.print("Masukkan judul tugas yang ingin dihapus: ");
        String judul = scanner.nextLine();

        tasks.removeIf(task -> task.getJudul().equalsIgnoreCase(judul));
        System.out.println("Tugas berhasil dihapus.");
    }

    private void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Daftar tugas kosong.");
        } else {
            System.out.println("Daftar Tugas:");
            tasks.forEach(System.out::println);
        }
    }

    public void start() {
        System.out.println("Selamat datang di Task Manager CLI");

        selectDataStructure();

        boolean quit = false;
        while (!quit) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Hapus Tugas");
            System.out.println("3. Tampilkan Tugas");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        System.out.println("Terima kasih telah menggunakan Task Manager CLI.");
    }

    public static void main(String[] args) {
        new Main().start();
    }
}
