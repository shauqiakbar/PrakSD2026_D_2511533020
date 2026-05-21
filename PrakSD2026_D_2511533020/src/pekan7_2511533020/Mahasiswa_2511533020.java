package pekan7_2511533020;

 class Mahasiswa_2511533020 {
    private String nama_3020;
    private String nim_3020;
    private String prodi_3020;

    // Constructor
    public Mahasiswa_2511533020(String nama_3020, String nim_3020, String prodi_3020) {
        this.nama_3020 = nama_3020;
        this.nim_3020 = nim_3020;
        this.prodi_3020 = prodi_3020;
    }

    // Getter
    public String getNama_3020() {
        return nama_3020;
    }

    public String getNim_3020() {
        return nim_3020;
    }

    public String getProdi_3020() {
        return prodi_3020;
    }

    // Setter
    public void setNama_3020(String nama_3020) {
        this.nama_3020 = nama_3020;
    }

    public void setNim_3020(String nim_3020) {
        this.nim_3020 = nim_3020;
    }

    public void setProdi_3020(String prodi_3020) {
        this.prodi_3020 = prodi_3020;
    }

    // toString untuk menampilkan data
    @Override
    public String toString() {
        return nama_3020 + " (" + nim_3020 + " - " + prodi_3020 + ")";
    }
}