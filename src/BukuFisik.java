public class BukuFisik extends Buku implements PengembalianBuku {
    private String noRak;
    private String kategoriLorong; 
    private String tahunTerbit;  
    private final double TARIF_DENDA_PER_HARI = 2000.0; 

    public BukuFisik(String idBuku, String judulBuku, String penulis, GenreBuku genre, String noRak, String kategoriLorong, String tahunTerbit) {
        super(idBuku, judulBuku, penulis, genre);
        this.noRak = noRak;
        this.kategoriLorong = kategoriLorong;
        this.tahunTerbit = tahunTerbit;
      
    }

    public String getNoRak() { return noRak; }
    public void setNoRak(String noRak) { this.noRak = noRak; }

    public String getKategoriLorong() { return kategoriLorong; }
    public void setKategoriLorong(String kategoriLorong) { this.kategoriLorong = kategoriLorong; }

    public String getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(String tahunTerbit) { this.tahunTerbit = tahunTerbit; }

    @Override
    public double hitungDenda(int hariTerlambat) {
        if (hariTerlambat > 0) {
            return hariTerlambat * TARIF_DENDA_PER_HARI;
        }
        return 0.0;
    }

    @Override
    public void prosesPengembalian(int hariTerlambat) {
        double totalDenda = hitungDenda(hariTerlambat);

        System.out.println("=== PROSES PENGEMBALIAN BUKU FISIK ===");
        System.out.println("ID Buku    : " + getIdBuku());
        System.out.println("Judul Buku : " + getJudulBuku());
        System.out.println("Lokasi     : Rak " + noRak + " (" + kategoriLorong + ")");
        
        if (totalDenda > 0) {
            System.out.println("Keterangan : Terlambat " + hariTerlambat + " hari");
            System.out.println("Total Denda: Rp " + totalDenda);
        } else {
            System.out.println("Keterangan : Pengembalian Tepat Waktu (Bebas Denda)");
        }
        System.out.println("-------------------------------------\n");
    }
} 
