package lasilu;

/**
 * JawabanSiswa
 */
public class JawabanSiswa {

  private int idJawabanSiswa;
  private String kontenJawaban;
  private Siswa siswa;
  private Ujian ujian;

  public JawabanSiswa(int idJawabanSiswa, String kontenJawaban, Siswa siswa, Ujian ujian){
    this.idJawabanSiswa = idJawabanSiswa;
    this.kontenJawaban = kontenJawaban;
    this.siswa = siswa;
    this.ujian = ujian;
    }
  
  public int getIdJawabanSiswa(){
    return idJawabanSiswa;
  }

  public void setIdJawabanSiswa(int idJawabanSiswa){
    this.idJawabanSiswa = idJawabanSiswa;
  }

  public String getKontenJawaban(){
    return kontenJawaban;
  }

  public Siswa getSiswa(){
    return siswa;
  }

  public Ujian getUjian(){
    return ujian;
  }
}

