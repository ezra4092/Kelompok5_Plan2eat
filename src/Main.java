import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULASI SISTEM PERPUSTAKAAN ===\n");

        // 1. Setup Data Genre
        GenreBuku gIT = new GenreBuku("G01", "Programming");
        GenreBuku gSE = new GenreBuku("G02", "Software Eng.");
        GenreBuku gfiksi = new GenreBuku("G03", "Fiksi");
        
        // Setup objek BukuFisik sesuai dengan parametermu: 
        // (idBuku, judulBuku, penulis, genre, noRak, kategoriLorong, tahunTerbit)
        BukuFisik b1 = new BukuFisik("B-001", "Java for Dummies", "Barry Burd", gIT, "Rak-1", "Lorong A", "2010");
        BukuFisik b2 = new BukuFisik("B-002", "Clean Code", "Robert C.", gSE, "Rak-2", "Lorong A", "2008");
        BukuFisik b3 = new BukuFisik("F-001", "Bumi Manusia", "Pramoedya A", gfiksi, "Rak-5", "Lorong C", "1980");
        
        // Masukkan ke inventory
        List<BukuFisik> rak = new ArrayList<>();
        rak.add(b1);
        rak.add(b2);
        rak.add(b3);

        Member m1 = new Member("M01", "Budi", "budi@email.com", "0811");
        Member m2 = new Member("M02", "Siti", "siti@email.com", "0822");
        Staff s1 = new Staff("S01", "Andi", "andi@email.com", "0833");

        // 2. Pencatatan & Peminjaman
        System.out.println("--- PENCATATAN & PEMINJAMAN ---");
        s1.tambahPeminjam(m1.getNama());
        s1.tambahPeminjam(m2.getNama());
        
        m1.pinjamBuku(b1); 
        m2.pinjamBuku(b2); 
        m1.pinjamBuku(b1); // Test case gagal (Validasi)

        System.out.println("\n--- DAFTAR BUKU DI TANGAN MEMBER ---");
        m1.displayBuku();
        m2.displayBuku();

        // 3. Tabel Buku Fisik (Tabel Lengkap + Status)
        System.out.println("--- TABEL INVENTORY BUKU FISIK ---");
        
        // Garis batas dilebarkan untuk nampung kolom Lorong dan Status
        String batas = "-------------------------------------------------------------------------------------------------------------------";
        System.out.println(batas);
        
        // Tambah header Lorong dan Status
        System.out.printf("| %-5s | %-18s | %-12s | %-15s | %-6s | %-8s | %-5s | %-10s |%n", 
                          "ID", "Judul", "Penulis", "Genre", "Rak", "Lorong", "Tahun", "Status");
        System.out.println(batas);
        
        for (BukuFisik b : rak) {
            // Pastikan method getter untuk lorong namanya getKategoriLorong() sesuai atributmu
            System.out.printf("| %-5s | %-18s | %-12s | %-15s | %-6s | %-8s | %-5s | %-10s |%n",
                    b.getIdBuku(), b.getJudulBuku(), b.getAuthor(), 
                    b.getGenre().getNamaGenre(), b.getNoRak(), b.getKategoriLorong(), b.getTahunTerbit(), b.getStatus());
        }
        System.out.println(batas);
    }
}