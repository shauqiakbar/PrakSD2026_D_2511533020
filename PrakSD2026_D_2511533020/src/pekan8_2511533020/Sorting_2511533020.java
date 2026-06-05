package pekan8_2511533020;

import java.util.Scanner;

public class Sorting_2511533020 {
    private Lagu_2511533020[] dataLagu_3020;
    private int jumlahLagu_3020;

    public Sorting_2511533020() {
        dataLagu_3020 = new Lagu_2511533020[20];
        jumlahLagu_3020 = 0;
    }

    // Method inputData_3020 - mengisi data awal minimal 7 lagu (LAGU BERBEDA)
    public void inputData_3020() {
        dataLagu_3020[0] = new Lagu_2511533020("Bohemian Rhapsody", "Queen", 354);
        dataLagu_3020[1] = new Lagu_2511533020("Shape of You", "Ed Sheeran", 233);
        dataLagu_3020[2] = new Lagu_2511533020("Blinding Lights", "The Weeknd", 200);
        dataLagu_3020[3] = new Lagu_2511533020("Rolling in the Deep", "Adele", 228);
        dataLagu_3020[4] = new Lagu_2511533020("Uptown Funk", "Bruno Mars", 270);
        dataLagu_3020[5] = new Lagu_2511533020("Hello", "Adele", 295);
        dataLagu_3020[6] = new Lagu_2511533020("Happier", "Marshmello", 204);
        jumlahLagu_3020 = 7;
        System.out.println("Data awal (7 lagu) telah dimasukkan.");
    }

    // Method quickSort_3020 (sama seperti sebelumnya)
    public void quickSort_3020(int low, int high) {
        if (low < high) {
            int pi = partition_3020(low, high);
            quickSort_3020(low, pi - 1);
            quickSort_3020(pi + 1, high);
        }
    }

    private int partition_3020(int low, int high) {
        int pivot = dataLagu_3020[high].getDurasi_3020();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (dataLagu_3020[j].getDurasi_3020() <= pivot) {
                i++;
                swap_3020(i, j);
            }
        }
        swap_3020(i + 1, high);
        return i + 1;
    }

    private void swap_3020(int i, int j) {
        Lagu_2511533020 temp = dataLagu_3020[i];
        dataLagu_3020[i] = dataLagu_3020[j];
        dataLagu_3020[j] = temp;
    }

    public void tampilData_3020() {
        if (jumlahLagu_3020 == 0) {
            System.out.println("Tidak ada data lagu.");
            return;
        }
        for (int i = 0; i < jumlahLagu_3020; i++) {
            System.out.println((i + 1) + ". " + dataLagu_3020[i].toString());
        }
    }

    public void pilihAlgoritma_3020(int pilihan) {
        if (pilihan == 2) {
            System.out.println("\nMemilih Quick Sort (berdasarkan Durasi Ascending)");
            quickSort_3020(0, jumlahLagu_3020 - 1);
            System.out.println("Data Setelah Quick Sort (Durasi Asc):");
        } else {
            System.out.println("Pilihan tidak valid. Hanya Quick Sort (2) yang tersedia.");
        }
    }

    public static void main(String[] args) {
        Scanner input_3020 = new Scanner(System.in);
        Sorting_2511533020 program = new Sorting_2511533020();

        System.out.println("=== Sorting Playlist NIM: 2511533020 ===");
        System.out.print("Pilih Algoritma (1=Shell, 2=Quick, 3=Merge): ");
        int pilih = input_3020.nextInt();

        program.inputData_3020();

        System.out.println("\nData Sebelum Sorting:");
        program.tampilData_3020();

        program.pilihAlgoritma_3020(pilih);
        program.tampilData_3020();

        input_3020.close();
    }
}