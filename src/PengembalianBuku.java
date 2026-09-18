public interface PengembalianBuku {
    //method untuk proses pengembalian dan perhitungan denda
    double hitungDenda(int hariTerlambat);
    void prosesPengembalian(int hariTerlambat);
}