package pekan7_2511533020;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SortingGUI_2511533020 extends JFrame {
    // Komponen GUI
    private JTextField fieldNama_3020, fieldNim_3020, fieldProdi_3020;
    private JButton btnTambah_3020, btnHapus_3020, btnSort_3020;
    private JComboBox<String> comboAlgoritma_3020;
    private JTable tabelMahasiswa_3020;
    private DefaultTableModel tableModel_3020;
    private JTextArea areaVisualisasi_3020;
    private JScrollPane scrollTabel_3020, scrollVisual_3020;

    // Tempat Simpan Data 
    private ArrayList<Mahasiswa_2511533020> daftarMahasiswa_3020;

    // Constructor
    public SortingGUI_2511533020() {
        daftarMahasiswa_3020 = new ArrayList<>();
        initComponents_3020();
        setTitle("Sorting Nama Mahasiswa - NIM: 2511533020");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Inisialisasi semua komponen GUI
     */
    private void initComponents_3020() {
        setLayout(new BorderLayout());

        // Panel Input (atas)
        JPanel panelInput_3020 = new JPanel(new GridLayout(2, 4, 10, 10));
        panelInput_3020.setBorder(BorderFactory.createTitledBorder("Input Data Mahasiswa"));

        panelInput_3020.add(new JLabel("Nama:"));
        fieldNama_3020 = new JTextField();
        panelInput_3020.add(fieldNama_3020);

        panelInput_3020.add(new JLabel("NIM:"));
        fieldNim_3020 = new JTextField();
        panelInput_3020.add(fieldNim_3020);

        panelInput_3020.add(new JLabel("Program Studi:"));
        fieldProdi_3020 = new JTextField();
        panelInput_3020.add(fieldProdi_3020);

        btnTambah_3020 = new JButton("Tambah Data");
        btnHapus_3020 = new JButton("Hapus Data");
        panelInput_3020.add(btnTambah_3020);
        panelInput_3020.add(btnHapus_3020);

        add(panelInput_3020, BorderLayout.NORTH);

        // Panel Tengah (tabel dan visualisasi)
        JPanel panelTengah_3020 = new JPanel(new GridLayout(1, 2, 10, 10));

        // Tabel data mahasiswa
        String[] kolom_3020 = {"No", "Nama", "NIM", "Prodi"};
        tableModel_3020 = new DefaultTableModel(kolom_3020, 0);
        tabelMahasiswa_3020 = new JTable(tableModel_3020);
        scrollTabel_3020 = new JScrollPane(tabelMahasiswa_3020);
        scrollTabel_3020.setBorder(BorderFactory.createTitledBorder("Data Mahasiswa"));
        panelTengah_3020.add(scrollTabel_3020);

        // Area visualisasi sorting (GUI)
        areaVisualisasi_3020 = new JTextArea();
        areaVisualisasi_3020.setEditable(false);
        areaVisualisasi_3020.setFont(new Font("Monospaced", Font.PLAIN, 12));
        scrollVisual_3020 = new JScrollPane(areaVisualisasi_3020);
        scrollVisual_3020.setBorder(BorderFactory.createTitledBorder("Visualisasi Proses Sorting (GUI)"));
        panelTengah_3020.add(scrollVisual_3020);

        add(panelTengah_3020, BorderLayout.CENTER);

        // Panel Bawah (pilihan algoritma dan tombol sort)
        JPanel panelBawah_3020 = new JPanel(new FlowLayout());

        panelBawah_3020.add(new JLabel("Pilih Algoritma Sorting:"));
        String[] algoritma_3020 = {"Insertion Sort", "Selection Sort", "Bubble Sort"};
        comboAlgoritma_3020 = new JComboBox<>(algoritma_3020);
        panelBawah_3020.add(comboAlgoritma_3020);

        btnSort_3020 = new JButton("Mulai Sorting");
        panelBawah_3020.add(btnSort_3020);

        add(panelBawah_3020, BorderLayout.SOUTH);

        // Event Listener
        btnTambah_3020.addActionListener(e -> tambahData_3020());
        btnHapus_3020.addActionListener(e -> hapusData_3020());
        btnSort_3020.addActionListener(e -> mulaiSorting_3020());
    }

    /**
     * Menambahkan data mahasiswa ke dalam ArrayList dan tabel
     */
    private void tambahData_3020() {
        String nama = fieldNama_3020.getText().trim();
        String nim = fieldNim_3020.getText().trim();
        String prodi = fieldProdi_3020.getText().trim();

        if (nama.isEmpty() || nim.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
        }

        Mahasiswa_2511533020 mhs = new Mahasiswa_2511533020(nama, nim, prodi);
        daftarMahasiswa_3020.add(mhs);
        refreshTabel_3020();

        fieldNama_3020.setText("");
        fieldNim_3020.setText("");
        fieldProdi_3020.setText("");
        fieldNama_3020.requestFocus();

        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
    }

    /**
     * Menghapus data mahasiswa yang dipilih dari tabel
     */
    private void hapusData_3020() {
        int selectedRow = tabelMahasiswa_3020.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
            return;
        }

        daftarMahasiswa_3020.remove(selectedRow);
        refreshTabel_3020();
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
    }

    /**
     * Merefresh tampilan tabel sesuai isi ArrayList
     */
    private void refreshTabel_3020() {
        tableModel_3020.setRowCount(0);
        for (int i = 0; i < daftarMahasiswa_3020.size(); i++) {
            Mahasiswa_2511533020 m = daftarMahasiswa_3020.get(i);
            tableModel_3020.addRow(new Object[]{
                i + 1,
                m.getNama_3020(),
                m.getNim_3020(),
                m.getProdi_3020()
            });
        }
    }

    /**
     * Memulai proses sorting sesuai algoritma yang dipilih
     * Visualisasi ditampilkan di console DAN di GUI
     */
    private void mulaiSorting_3020() {
        if (daftarMahasiswa_3020.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tidak ada data untuk di-sort!");
            return;
        }

        String algoritma = (String) comboAlgoritma_3020.getSelectedItem();
        
        // Bersihkan area visualisasi GUI
        areaVisualisasi_3020.setText("");
        
        // Tampilkan di console
        System.out.println("\n=========================================");
        System.out.println("=== " + algoritma + " ===");
        System.out.println("=========================================");
        
        // Tampilkan di GUI
        areaVisualisasi_3020.append("=== " + algoritma + " ===\n\n");
        
        // Tampilkan data awal (console dan GUI)
        System.out.print("Data Awal: ");
        areaVisualisasi_3020.append("Data Awal:\n");
        tampilkanDataAwal_3020(true); // true = cetak ke console juga
        
        // Buat salinan data untuk di-sort
        ArrayList<Mahasiswa_2511533020> dataCopy = new ArrayList<>(daftarMahasiswa_3020);

        if (algoritma.equals("Insertion Sort")) {
            insertionSort_3020(dataCopy);
        } else if (algoritma.equals("Selection Sort")) {
            selectionSort_3020(dataCopy);
        } else if (algoritma.equals("Bubble Sort")) {
            bubbleSort_3020(dataCopy);
        }

        // Tampilkan hasil akhir (console dan GUI)
        System.out.print("\n=== HASIL AKHIR ===\n");
        areaVisualisasi_3020.append("\n\n=== HASIL AKHIR ===\n");
        tampilkanHasilAkhir_3020(dataCopy, true);

        // Update daftar mahasiswa dengan hasil sorting
        daftarMahasiswa_3020 = dataCopy;
        refreshTabel_3020();

        JOptionPane.showMessageDialog(this, "Sorting selesai! Lihat console untuk detail langkah-langkah sorting.");
    }

    /**
     * Menampilkan data awal ke area visualisasi (GUI) dan console
     */
    private void tampilkanDataAwal_3020(boolean keConsole) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < daftarMahasiswa_3020.size(); i++) {
            sb.append(daftarMahasiswa_3020.get(i).getNama_3020());
            if (i < daftarMahasiswa_3020.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]\n\n");
        
        areaVisualisasi_3020.append(sb.toString());
        
        if (keConsole) {
            System.out.print(sb.toString());
        }
    }

    /**
     * Menampilkan hasil akhir sorting ke area visualisasi (GUI) dan console
     */
    private void tampilkanHasilAkhir_3020(ArrayList<Mahasiswa_2511533020> data, boolean keConsole) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i).getNama_3020());
            if (i < data.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]\n");
        
        areaVisualisasi_3020.append(sb.toString());
        
        if (keConsole) {
            System.out.print(sb.toString());
        }
    }
    
    /**
     * Menampilkan langkah sorting ke area visualisasi (GUI) dan console
     */
    private void tampilkanLangkahSorting_3020(ArrayList<Mahasiswa_2511533020> data, String prefix, int nomor, boolean keConsole) {
        StringBuilder sb = new StringBuilder(prefix + " " + nomor + " : [");
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i).getNama_3020());
            if (i < data.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]\n");
        
        areaVisualisasi_3020.append(sb.toString());
        
        if (keConsole) {
            System.out.print(sb.toString());
        }
    }

    /**
     * INSERTION SORT - mengurutkan data berdasarkan nama (case insensitive)
     * Menampilkan setiap langkah perubahan ke console dan GUI
     */
    private void insertionSort_3020(ArrayList<Mahasiswa_2511533020> data) {
        int langkah = 1;
        System.out.println("\n--- PROSES INSERTION SORT ---");
        areaVisualisasi_3020.append("--- PROSES INSERTION SORT ---\n");
        
        for (int i = 1; i < data.size(); i++) {
            Mahasiswa_2511533020 key = data.get(i);
            int j = i - 1;
            
            String penjelasan = "Memasukkan \"" + key.getNama_3020() + "\" ke posisi yang tepat";
            
            System.out.println("Langkah " + langkah + ": " + penjelasan);
            areaVisualisasi_3020.append("Langkah " + langkah + ": " + penjelasan + "\n");

            while (j >= 0 && data.get(j).getNama_3020().compareToIgnoreCase(key.getNama_3020()) > 0) {
                data.set(j + 1, data.get(j));
                j--;
            }
            data.set(j + 1, key);

            tampilkanLangkahSorting_3020(data, "Hasil", langkah, true);
            langkah++;
        }
    }

    /**
     * SELECTION SORT - mengurutkan data berdasarkan nama (case insensitive)
     * Menampilkan setiap pass ke console dan GUI
     */
    private void selectionSort_3020(ArrayList<Mahasiswa_2511533020> data) {
        int pass = 1;
        System.out.println("\n--- PROSES SELECTION SORT ---");
        areaVisualisasi_3020.append("--- PROSES SELECTION SORT ---\n");
        
        for (int i = 0; i < data.size() - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j).getNama_3020().compareToIgnoreCase(data.get(minIdx).getNama_3020()) < 0) {
                    minIdx = j;
                }
            }
      
            String penjelasan = "Menukar \"" + data.get(minIdx).getNama_3020() + "\" dengan \"" + data.get(i).getNama_3020() + "\"";
        
            Mahasiswa_2511533020 temp = data.get(minIdx);
            data.set(minIdx, data.get(i));
            data.set(i, temp);

            System.out.println("Pass " + pass + ": " + penjelasan);
            areaVisualisasi_3020.append("Pass " + pass + ": " + penjelasan + "\n");
            
            tampilkanLangkahSorting_3020(data, "Hasil", pass, true);
            pass++;
        }
    }

    /**
     * BUBBLE SORT - mengurutkan data berdasarkan nama (case insensitive)
     * Menampilkan setiap pass ke console dan GUI
     */
    private void bubbleSort_3020(ArrayList<Mahasiswa_2511533020> data) {
        int pass = 1;
        System.out.println("\n--- PROSES BUBBLE SORT ---");
        areaVisualisasi_3020.append("--- PROSES BUBBLE SORT ---\n");
        
        for (int i = 0; i < data.size() - 1; i++) {
            boolean swapped = false;
            String pertukaranTerakhir = "";
            
            for (int j = 0; j < data.size() - i - 1; j++) {
                if (data.get(j).getNama_3020().compareToIgnoreCase(data.get(j + 1).getNama_3020()) > 0) {
                    Mahasiswa_2511533020 temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                    swapped = true;
                    pertukaranTerakhir = "Menukar \"" + data.get(j).getNama_3020() + "\" dengan \"" + data.get(j + 1).getNama_3020() + "\"";
                }
            }
            
          
            String penjelasan;
            if (swapped) {
                penjelasan = pertukaranTerakhir + " (menggelembungkan nilai terbesar)";
            } else {
                penjelasan = "Tidak ada pertukaran, array sudah terurut";
            }
            
            System.out.println("Pass " + pass + ": " + penjelasan);
            areaVisualisasi_3020.append("Pass " + pass + ": " + penjelasan + "\n");
            
          
            tampilkanLangkahSorting_3020(data, "Hasil", pass, true);
            pass++;

            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Main method - menjalankan program GUI
     */
    public static void main(String[] args) {
        System.out.println("=== PROGRAM SORTING NAMA MAHASISWA ===");
        System.out.println("NIM: 2511533020");
        System.out.println("Visualisasi langkah-langkah sorting akan ditampilkan di console ini.\n");
        
        SwingUtilities.invokeLater(() -> {
            new SortingGUI_2511533020().setVisible(true);
        });
    }
}