import java.util.List;
import java.util.ArrayList;

public class Pustakawan extends Staff {
    private List<String> daftarNamaPeminjam; // List array dipindah ke sini

    public Pustakawan(String idStaff, String nama, String email, String noTelp) {
        super(idStaff, nama, email, noTelp);
        this.daftarNamaPeminjam = new ArrayList<>();
    }

    public List<String> getDaftarNamaPeminjam() {
        return daftarNamaPeminjam;
    }

    // mencatat peminjam dipindah ke sini
    public void tambahPeminjam(String namaMember) {
        if (namaMember != null && !namaMember.trim().isEmpty()) {
            daftarNamaPeminjam.add(namaMember);
            System.out.println("Sukses: Member '" + namaMember + "' ditambahkan ke daftar peminjam oleh Pustakawan " + getNama() + ".");
        }
    }

    // menampilkan peminjam dipindah ke sini
    public void tampilkanDaftarPeminjam() {
        System.out.println("\n--- Daftar Member yang Meminjam Buku (Dikelola oleh " + getNama() + ") ---");
        if (daftarNamaPeminjam.isEmpty()) {
            System.out.println("Belum ada member yang meminjam buku.");
            return;
        }
        for (int i = 0; i < daftarNamaPeminjam.size(); i++) {
            System.out.println((i + 1) + ". " + daftarNamaPeminjam.get(i));
        }
        System.out.println("--------------------------------------------------------------\n");
    }

    // Implementasi abstract class Staff
    @Override
    public void kerjakanTugas() {
        System.out.println(getNama() + " (Pustakawan) sedang bersiap di Resepsionis Perpustakaan melayani peminjaman buku.");
    }
}