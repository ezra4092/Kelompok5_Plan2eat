public class PetugasKeamanan extends Staff {

    public PetugasKeamanan(String idStaff, String nama, String email, String noTelp) {
        super(idStaff, nama, email, noTelp);
    }

    // Implementasi 
    @Override
    public void kerjakanTugas() {
        System.out.println(getNama() + " (Keamanan) sedang berpatroli mengecek CCTV dan tas pengunjung.");
    }
}