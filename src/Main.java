import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        // --- HEADER APLIKASI ---
        System.out.println("==================================================");
        System.out.println("          SIMULASI SISTEM PERPUSTAKAAN            ");
        System.out.println("==================================================\n");

        // ==========================================
        // 1. SETUP DATA (Genre, Buku, Member, Staff)
        // ==========================================
        // Setup Data Genre
        GenreBuku genreIT = new GenreBuku("G01", "Programming");
        GenreBuku genreSE = new GenreBuku("G02", "Software Engineering");
        GenreBuku genreFiksi = new GenreBuku("G03", "Fiksi");

        // Setup Data Buku (Superclass)
        Buku buku1 = new Buku("B001", "Java for Dummies", "Barry Burd", genreIT);
        Buku buku2 = new Buku("B002", "Clean Code", "Robert C. Martin", genreSE);
        Buku buku3 = new Buku("B003", "Head First Java", "Kathy Sierra", genreIT);

        // Setup Data Member
        Member member1 = new Member("M01", "Budi", "budi@email.com", "08123456789");
        Member member2 = new Member("M02", "Siti", "siti@email.com", "08987654321");

        // Setup Data Staff
        Staff staff1 = new Staff("S01", "Andi", "andi@email.com", "08111111111");


        // ==========================================
        // SKENARIO 1: PENCATATAN OLEH STAFF
        // ==========================================
        System.out.println(">>> 1. PROSES PENCATATAN MEMBER OLEH STAFF <<<");
        // Staff A (Andi) memasukkan data Member A (Budi) dan Member B (Siti) ke sistem
        staff1.tambahPeminjam(member1.getNama());
        staff1.tambahPeminjam(member2.getNama());
        
        // Menampilkan rekap member
        staff1.tampilkanDaftarPeminjam();


        // ==========================================
        // SKENARIO 2: PROSES PEMINJAMAN
        // ==========================================
        System.out.println(">>> 2. PROSES PEMINJAMAN BUKU <<<");
        member1.pinjamBuku(buku1); 
        member1.pinjamBuku(buku2); 
        member2.pinjamBuku(buku3);
        
        System.out.println("\n[Daftar Buku di Tangan Member]");
        member1.displayBuku();
        member2.displayBuku();


        // ==========================================
        // SKENARIO 3: TEST CASE GAGAL
        // ==========================================
        System.out.println(">>> 3. TEST CASE GAGAL (VALIDASI) <<<");
        member1.pinjamBuku(buku1); // Budi minjem buku yang sudah dia pinjam
        member2.pinjamBuku(buku1); // Siti nyoba minjem buku yang lagi dipinjem Budi


        // ==========================================
        // SKENARIO 4: STATUS BUKU SAAT INI
        // ==========================================
        System.out.println("\n>>> 4. STATUS INVENTORY BUKU SAAT INI <<<");
        System.out.println("- B001 (" + buku1.getJudulBuku() + ") \t: " + buku1.getStatus()); 
        System.out.println("- B002 (" + buku2.getJudulBuku() + ") \t\t: " + buku2.getStatus()); 
        System.out.println("- B003 (" + buku3.getJudulBuku() + ") \t: " + buku3.getStatus()); 


        // ==========================================
        // SKENARIO 5: TABEL DATA BUKU FISIK
        // ==========================================
        System.out.println("\n>>> 5. TABEL DATA BUKU FISIK <<<");
        
        List<BukuFisik> daftarBuku = new ArrayList<>();
        
        // Asumsi urutan parameter di class BukuFisik: (id, judul, author, genre, rak, tahun)
        daftarBuku.add(new BukuFisik("B-001", "Struktur Data", "Thomas H", genreIT, "Rak-1", "Lorong A", "Baru"));
        daftarBuku.add(new BukuFisik("B-002", "Clean Code", "Robert C", genreIT, "Rak-2", "Lorong A", "Baik"));
        daftarBuku.add(new BukuFisik("F-001", "Bumi Manusia", "Pramoedya A", genreFiksi, "Rak-5", "Lorong C", "Rusak"));

        // String garis pembatas 
        String garisBatas = "------------------------------------------------------------------------------------------------";
        
        System.out.println(garisBatas);
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