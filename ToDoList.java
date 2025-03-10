import java.util.ArrayList;
import java.util.Scanner;

// Kelas utama untuk manajemen daftar tugas
public class ToDoList {
    private ArrayList<String> tasks = new ArrayList<>();
    private ArrayList<Boolean> completed = new ArrayList<>();

    // Menambahkan tugas baru
    public void addTask(String task) {
        tasks.add(task);
        completed.add(false);
        System.out.println("DEBUG: Tugas \"" + task + "\" ditambahkan."); // Debug print
    }

    // Menampilkan semua tugas
    public void showTasks() {
        System.out.println("\nDaftar Tugas:");
        for (int i = 0; i < tasks.size(); i++) {
            String status = completed.get(i) ? "[Selesai]" : "[Belum Selesai]";
            System.out.println((i + 1) + ". " + tasks.get(i) + " " + status);
        }
        System.out.println("DEBUG: Daftar tugas ditampilkan."); // Debug print
    }

    // Menandai tugas sebagai selesai
    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            completed.set(index, true);
            System.out.println("DEBUG: Tugas \"" + tasks.get(index) + "\" ditandai selesai."); // Debug print
        } else {
            System.out.println("DEBUG: Indeks tugas tidak valid!"); // Debug print
        }
    }

    // Menghapus tugas dari daftar
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            System.out.println("DEBUG: Tugas \"" + tasks.get(index) + "\" dihapus."); // Debug print
            tasks.remove(index);
            completed.remove(index);
        } else {
            System.out.println("DEBUG: Indeks tugas tidak valid!"); // Debug print
        }
    }

    // Menghitung jumlah tugas yang belum selesai
    public int countPendingTasks() {
        int count = 0;
        for (Boolean status : completed) {
            if (!status) {
                count++;
            }
        }
        System.out.println("DEBUG: Jumlah tugas yang belum selesai: " + count); // Debug print
        return count;
    }

    // Menghitung jumlah tugas yang selesai
    public int countCompletedTasks() {
        int count = 0;
        for (Boolean status : completed) {
            if (status) {
                count++;
            }
        }
        System.out.println("DEBUG: Jumlah tugas yang selesai: " + count); // Debug print
        return count;
    }

    // Mengecek apakah daftar tugas kosong
    public boolean isEmpty() {
        boolean empty = tasks.isEmpty();
        System.out.println("DEBUG: Apakah daftar tugas kosong? " + empty); // Debug print
        return empty;
    }

    // Program utama untuk menjalankan fitur
    public static void main(String[] args) {
        ToDoList todo = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Lihat Daftar Tugas");
            System.out.println("3. Tandai Selesai");
            System.out.println("4. Hapus Tugas");
            System.out.println("5. Hitung Tugas Selesai");
            System.out.println("6. Hitung Tugas Belum Selesai");
            System.out.println("7. Cek Daftar Kosong");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan tugas: ");
                    String task = scanner.nextLine();
                    todo.addTask(task);
                    break;
                case 2:
                    todo.showTasks();
                    break;
                case 3:
                    System.out.print("Masukkan nomor tugas yang selesai: ");
                    int selesai = scanner.nextInt() - 1;
                    todo.completeTask(selesai);
                    break;
                case 4:
                    System.out.print("Masukkan nomor tugas yang ingin dihapus: ");
                    int hapus = scanner.nextInt() - 1;
                    todo.removeTask(hapus);
                    break;
                case 5:
                    todo.countCompletedTasks();
                    break;
                case 6:
                    todo.countPendingTasks();
                    break;
                case 7:
                    todo.isEmpty();
                    break;
                case 8:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
