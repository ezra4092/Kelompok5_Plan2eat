import java.util.List;
import java.util.ArrayList;

public class Member extends Person {
    private String id;
    private List<Buku> bukuList;

    public String getId() { 
        return id; 
    }

    public List<Buku> getBukuList() { 
        return bukuList; 
    }

    public Member(String id, String nama, String email, String noTelp) {
        super(nama, email, noTelp); // Memanggil konstruktor Person dengan nama, email, dan noTelp kosong
        this.id = id;
        this.bukuList = new ArrayList<>();
    }

    public void pinjamBuku(Buku buku) {
        if (buku.getStatus().equals("Dipinjam")) {
            System.out.println("Gagal: Buku '" + buku.getJudulBuku() + "' sedang dipinjam.");
            return; 
        }

        if (!bukuList.contains(buku)) {
            bukuList.add(buku);
            buku.setStatus("Dipinjam"); 
            System.out.println("Sukses: " + getNama() + " berhasil meminjam '" + buku.getJudulBuku() + "'");
        } else {
            System.out.println("Gagal: " + getNama()     + " sudah meminjam buku ini.");
        }
    }

     public void kembalikanBuku(Buku buku) {
        if (bukuList.contains(buku)) {
            bukuList.remove(buku);
            buku.setStatus("Tersedia");
            System.out.println("Sukses: " + getNama() + " telah mengembalikan '" + buku.getJudulBuku() + "'");
        } else {
            System.out.println("Gagal: " + getNama() + " tidak sedang meminjam buku ini.");
        }
    }

    public void displayBuku() {
        System.out.println("\n--- Daftar Buku dipinjam oleh " + getNama() + " ---");
        if (bukuList.isEmpty()) {
            System.out.println("Belum ada buku yang dipinjam.");
            return;
        }
        for (Buku buku : bukuList) {
            // Update disini: Manggil nama genre dari objek buku -> genre -> namaGenre
            System.out.println("- [" + buku.getIdBuku() + "] " + buku.getJudulBuku() + 
                               " by " + buku.getAuthor() + 
                               " (Genre: " + buku.getGenre().getNamaGenre() + ")");
        }
        System.out.println("----------------------------------------\n");
    }

}
