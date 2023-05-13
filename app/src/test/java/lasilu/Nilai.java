package lasilu;

/**
 * Nilai
 */
public class Nilai {

  private Siswa siswa;
  private MataPelajaran mataPelajaran;
  private Ujian ujian;
  private double nilaiAkhir;

  public Nilai(Siswa siswa, MataPelajaran mataPelajaran, Ujian ujian, double nilaiAkhir){
    this.siswa = siswa;
    this.mataPelajaran = mataPelajaran;
    this.ujian = ujian;
    this.nilaiAkhir = nilaiAkhir;
  }

  public Siswa getSiswa(){
    return siswa;
  }

  public MataPelajaran getMataPelajaran(){
    return mataPelajaran;
  }

  public Ujian getUjian(){
    return ujian;
  }

  public double getNilaiAkhir(){
    return nilaiAkhir;
  }

  public void setNilaiAkhir(double nilaiAkhir){
    this.nilaiAkhir = nilaiAkhir;
  }
}
