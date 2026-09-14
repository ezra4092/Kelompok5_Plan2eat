public class Buku {
    private String idBuku;
    private String judulBuku;
    private String author; 
    private String status;
    private GenreBuku genre; // Relasi ke class GenreBuku

    // Constructor diupdate biar pas bikin buku langsung masukin genrenya
    public Buku(String idBuku, String judulBuku, String author, GenreBuku genre) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.author = author;
        this.status = "Tersedia";
        this.genre = genre;
    }
    
    public String getIdBuku() { return idBuku; }
    public void setIdBuku(String idBuku) { this.idBuku = idBuku; }
    
    public String getJudulBuku() { return judulBuku; }
    public void setJudulBuku(String judulBuku) { this.judulBuku = judulBuku; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public GenreBuku getGenre() { return genre; }
    public void setGenre(GenreBuku genre) { this.genre = genre; }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        if (status.equals("Dipinjam") || status.equals("Tersedia")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Status harus 'Dipinjam' atau 'Tersedia'");
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Buku buku = (Buku) obj;
        return idBuku.equals(buku.idBuku);
    }
}
