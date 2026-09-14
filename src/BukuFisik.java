public class BukuFisik extends Buku {
    private String noRak;
    private String kategoriLorong; 
    private String tahunTerbit;  

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
} 