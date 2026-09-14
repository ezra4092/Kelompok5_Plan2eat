public class Person {
    private String nama;
    private String email;
    private String noTelp;

    public Person(String nama, String email, String noTelp) {
        this.nama = nama;
        this.email = email;
        this.noTelp = noTelp;
    }

    public String getNama() {
        return nama;
    }   
    public String getEmail() {
        return email;
    }
    public String getNoTelp() {
        return noTelp;
    }

    public void setNama(String nama){ // Mengubah nilai nama dengan validasi input
        if (nama != null && nama.trim().isEmpty()){
            this.nama = nama;
        } else{
            System.out.println("Nama tidak boleh kosong");  
        }
    }

    public void setEmail(String email){ // Mengubah nilai email dengan validasi input
        if (email != null && email.trim().isEmpty()){
            this.email = email;
        } else{
            System.out.println("Email tidak boleh kosong");  
        }
    }

    public void tampilkanIdentitas(){ // Mencetak seluruh identitas person ke layar
        System.out.println("Nama: " + nama);
        System.out.println("Email: " + email);
        System.out.println("No. Telp: " + noTelp);
    }
}
