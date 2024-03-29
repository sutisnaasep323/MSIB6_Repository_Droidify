package Minggu6;

import java.util.LinkedList;

// Kelas TaskList merepresentasikan daftar tugas yang dapat ditambahkan, dihapus, dan ditampilkan.
class TaskList {
    // Daftar tugas disimpan dalam LinkedList
    private LinkedList<String> taskList;

    // Konstruktor untuk membuat objek TaskList dengan daftar tugas kosong.
    public TaskList() {
        this.taskList = new LinkedList<String>();
    }

    // Method untuk menambahkan tugas ke dalam daftar.
    // Parameter:
    // - task: String yang menyatakan tugas yang akan ditambahkan.
    public void addTask(String task) {
        this.taskList.add(task);
    }

    // Method untuk menghapus tugas dari daftar.
    // Parameter:
    // - task: String yang menyatakan tugas yang akan dihapus.
    public void removeTask(String task) {
        this.taskList.remove(task);
    }

    // Method untuk menampilkan seluruh daftar tugas.
    public void displayTasks() {
        System.out.println("Task List: ");
        for (String task : this.taskList) {
            System.out.println(task);
        }
    }
}

// Kelas utama yang berisi fungsi main sebagai contoh penggunaan kelas TaskList.
 class Main {
    public static void main(String[] args) {
        // Membuat objek TaskList
        TaskList taskList = new TaskList();
        
        // Menambahkan beberapa tugas ke dalam daftar
        taskList.addTask("Finish Java Tutorial");
        taskList.addTask("Start new Project");
        
        // Menampilkan seluruh daftar tugas
        taskList.displayTasks();
        
        // Menghapus tugas tertentu dari daftar
        taskList.removeTask("Finish Java Tutorial");
        
        // Menampilkan daftar tugas setelah penghapusan
        taskList.displayTasks();
    }
}
