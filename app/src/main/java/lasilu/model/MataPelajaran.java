package lasilu.model;

/**
 * MataPelajaran
 */
public class MataPelajaran {

  private int idMapel;
  private String namaMapel;
  private String jurusan;
  private Kelas kelas;

  public MataPelajaran() {

  }

  public MataPelajaran(int idMapel, String namaMapel, String jurusan, Kelas kelas) {
    this.idMapel = idMapel;
    this.namaMapel = namaMapel;
    this.jurusan = jurusan;
    this.kelas = kelas;
  }

  public int getIdMapel() {
    return idMapel;
  }

  public void setIdMapel(int idMapel) {
    this.idMapel = idMapel;
  }

  public String getNamaMapel() {
    return namaMapel;
  }

  public void setNamaMapel(String namaMapel) {
    this.namaMapel = namaMapel;
  }

  public String getJurusan() {
    return jurusan;
  }

  public void setJurusan(String jurusan) {
    this.jurusan = jurusan;
  }

  public Kelas getKelas() {
    return kelas;
  }

  public void setKelas(Kelas kelas) {
    this.kelas = kelas;
  }
}
