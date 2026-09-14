import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        // --- HEADER APLIKASI ---
        System.out.println("==================================================");
        System.out.println("          SIMULASI SISTEM PERPUSTAKAAN            ");
        System.out.println("==================================================\n");

        // 1. Setup Data Genre
        GenreBuku genre1 = new GenreBuku("Programming", "Buku bahasa pemrograman");
        GenreBuku genre2 = new GenreBuku("Software Eng.", "Buku rekayasa perangkat lunak");

        // 2. Setup Data Buku (Superclass)
        Buku buku1 = new Buku("B001", "Java for Dummies", "Barry Burd", genre1);
        Buku buku2 = new Buku("B002", "Clean Code", "Robert C. Martin", genre2);
        Buku buku3 = new Buku("B003", "Head First Java", "Kathy Sierra", genre1);

        // Setup Data Member
        Member member1 = new Member("M01", "Budi");
        Member member2 = new Member("M02", "Siti");

        // ==========================================
        // SKENARIO 1: PROSES PEMINJAMAN
        // ==========================================
        System.out.println(">>> 1. PROSES PEMINJAMAN BUKU <<<");
        member1.pinjamBuku(buku1); 
        member1.pinjamBuku(buku2); 
        member2.pinjamBuku(buku3);
        
        System.out.println("\n[Daftar Buku di Tangan Member]");
        member1.displayBuku();
        member2.displayBuku();

        // ==========================================
        // SKENARIO 2: TEST CASE GAGAL
        // ==========================================
        System.out.println("\n>>> 2. TEST CASE GAGAL (VALIDASI) <<<");
        member1.pinjamBuku(buku1); // Budi minjem buku yang sama
        member2.pinjamBuku(buku1); // Siti minjem buku yang sedang dipinjam Budi

        // ==========================================
        // SKENARIO 3: STATUS BUKU SAAT INI
        // ==========================================
        System.out.println("\n>>> 3. STATUS INVENTORY BUKU <<<");
        System.out.println("- B001 (" + buku1.getJudulBuku() + ") : " + buku1.getStatus()); 
        System.out.println("- B002 (" + buku2.getJudulBuku() + ") : " + buku2.getStatus()); 
        System.out.println("- B003 (" + buku3.getJudulBuku() + ") : " + buku3.getStatus()); 

        // ==========================================
        // SKENARIO 4: TABEL BUKU FISIK
        // ==========================================
        System.out.println("\n>>> 4. TABEL DATA BUKU FISIK <<<");
        
        GenreBuku genreIT = new GenreBuku("Teknologi", "Buku seputar IT");
        GenreBuku genreFiksi = new GenreBuku("Fiksi", "Novel dan Cerita");

        List<BukuFisik> daftarBuku = new ArrayList<>();
        
        // Catatan: Saya tambahkan parameter tahun (misal 2024, 2008, 1980) di paling belakang
        // Pastikan constructor BukuFisik kamu sudah menerima parameter tahunTerbit
        daftarBuku.add(new BukuFisik("B-001", "Struktur Data", "Thomas H", genreIT, "Rak-1", "Lorong A", "Baru"));
        daftarBuku.add(new BukuFisik("B-002", "Clean Code", "Robert C", genreIT, "Rak-2", "Lorong A", "Baik"));
        daftarBuku.add(new BukuFisik("F-001", "Bumi Manusia", "Pramoedya A", genreFiksi, "Rak-5", "Lorong C", "Rusak"));

        // String garis pembatas dibuat persis 96 karakter agar ujungnya menutup tabel dengan rata
        String garisBatas = "------------------------------------------------------------------------------------------------";
        
        System.out.println(garisBatas);
        // Header kolom dibuat Title Case agar terlihat profesional
        System.out.printf("| %-6s | %-20s | %-15s | %-15s | %-9s | %-12s |%n", 
                          "ID", "Judul Buku", "Penulis", "Genre", "No. Rak", "Tahun Terbit");
        System.out.println(garisBatas);

        for (BukuFisik buku : daftarBuku) {
            System.out.printf("| %-6s | %-20s | %-15s | %-15s | %-9s | %-12s |%n",
                    buku.getIdBuku(),
                    buku.getJudulBuku(),
                    buku.getAuthor(), 
                    buku.getGenre().getNamaGenre(),
                    buku.getNoRak(),
                    buku.getTahunTerbit() 
            );
        }
        System.out.println(garisBatas);
    }
}