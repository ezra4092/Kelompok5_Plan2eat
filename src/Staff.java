import java.util.List;
import java.util.ArrayList;

public abstract class Staff extends Person {
    private String idStaff;
    private List<String> daftarNamaPeminjam; // List array untuk menyimpan nama member

    public Staff(String idStaff, String nama, String email, String noTelp) {
        super(nama, email, noTelp); // Menginisialisasi atribut dari superclass Person
        this.idStaff = idStaff;
        this.daftarNamaPeminjam = new ArrayList<>();
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public List<String> getDaftarNamaPeminjam() {
        return daftarNamaPeminjam;
    }

    // Method untuk mencatat nama member yang meminjam buku ke dalam list
    public void tambahPeminjam(String namaMember) {
        if (namaMember != null && !namaMember.trim().isEmpty()) {
            daftarNamaPeminjam.add(namaMember);
            System.out.println("Sukses: Member '" + namaMember + "' ditambahkan ke daftar peminjam oleh Staff " + getNama() + ".");
        }
    }

    // Method untuk melihat seluruh nama member yang sudah meminjam
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

    public abstract void kerjakanTugas();
}
