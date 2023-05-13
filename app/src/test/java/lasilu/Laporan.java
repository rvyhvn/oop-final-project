package lasilu;
import java.util.Date;


/**
 * Laporan
 */
public class Laporan {

  private int idLaporan;
  private Date tanggal;
  private Siswa siswa;
  private Nilai nilai;

  public Laporan(int idLaporan, Date tanggal, Siswa siswa, Nilai nilai){
    this.idLaporan = idLaporan;
    this.tanggal = tanggal;
    this.siswa = siswa;
    this.nilai = nilai;
  }

  public int gteIdLaporan(){
    return idLaporan;
  }

  public Date getTanggal(){
    return tanggal;
  }

  public Siswa getSiswa(){
    return siswa;
  }

  public Nilai getNilai(){
    return nilai;
  }

  public void setIdLaporan(int idLaporan){
    this.idLaporan = idLaporan;
  }

  public void setTanggal(Date tanggal){
    this.tanggal = tanggal;
  }
}
