package lasilu;

import java.sql.Date;
import java.text.DateFormat;

/**
 * Ujian
 */
public class Ujian {

  private Date tglUjian;
  private DateFormat jamUjian;
  private Siswa siswa;
  private Guru guru;
  private MataPelajaran mataPelajaran;

  public Ujian(Date tglUjian, DateFormat jamUjian){
    this.tglUjian = tglUjian;
    this.jamUjian = jamUjian;
  }

  public Date getTglUjian(){
    return tglUjian;
  }

  public DateFormat getJamUjian(){
    return jamUjian;
  }

  public Siswa getSiswa(){
    return siswa;
  }

  public Guru getGuru(){
    return guru;
  }

  public MataPelajaran getMataPelajaran(){
    return mataPelajaran;
  }

  public void setTglUjian(Date tglUjian){
    this.tglUjian = tglUjian;
  }

  public void setJamUjian(DateFormat jamUjian){
    this.jamUjian = jamUjian;
  }
}
