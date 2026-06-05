package pekan8_2511533020;

public class Lagu_2511533020 {
    private String judul_3020;
    private String penyanyi_3020;
    private int durasi_3020; // dalam detik

    public Lagu_2511533020(String judul_3020, String penyanyi_3020, int durasi_3020) {
        this.judul_3020 = judul_3020;
        this.penyanyi_3020 = penyanyi_3020;
        this.durasi_3020 = durasi_3020;
    }

    public String getJudul_3020() { return judul_3020; }
    public String getPenyanyi_3020() { return penyanyi_3020; }
    public int getDurasi_3020() { return durasi_3020; }

    public void setJudul_3020(String judul_3020) { this.judul_3020 = judul_3020; }
    public void setPenyanyi_3020(String penyanyi_3020) { this.penyanyi_3020 = penyanyi_3020; }
    public void setDurasi_3020(int durasi_3020) { this.durasi_3020 = durasi_3020; }

    @Override
    public String toString() {
        return judul_3020 + " - " + penyanyi_3020 + " (" + durasi_3020 + " detik)";
    }
}