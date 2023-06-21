package lasilu.model;

/**
 * Guru
 */
public class Guru extends Entity {

  private int idGuru;
  private Kelas kelas;
  private MataPelajaran mataPelajaran;
  private Laporan laporan;
  private String password;

  public Guru(int idGuru, String nama, String email, String phone, Kelas kelas, MataPelajaran mataPelajaran,
      Laporan laporan, String password) {
    super(nama, email, phone);
    this.idGuru = idGuru;
    this.kelas = kelas;
    this.mataPelajaran = mataPelajaran;
    this.laporan = laporan;
    this.password = password;
  }

  public Guru() {
    super("", "", "");
    this.idGuru = 0;
    this.kelas = kelas;
    this.laporan = laporan;
  }

  public int getIdGuru() {
    return idGuru;
  }

  public void setIdGuru(int idGuru) {
    this.idGuru = idGuru;
  }

  public Kelas getKelas() {
    return kelas;
  }

  public void setKelas(Kelas kelas) {
    this.kelas = kelas;
  }

  public MataPelajaran getMapel() {
    return mataPelajaran;
  }

  public void setMapel(MataPelajaran mataPelajaran) {
    this.mataPelajaran = mataPelajaran;
  }

  public Laporan getLaporan() {
    return laporan;
  }

  public void setLaporan(Laporan laporan) {
    this.laporan = laporan;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
