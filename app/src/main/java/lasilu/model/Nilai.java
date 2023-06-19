package lasilu.model;

import lasilu.model.*;
import java.util.ArrayList;

/**
 * Nilai
 */
public class Nilai {

  private int idNilai;
  private double nilai;
  private double nilaiMean;
  private Siswa siswa;

  public Nilai() {

  }

  public Nilai(int idNilai, double nilai, double nilaiMean, Siswa siswa) {
    this.idNilai = idNilai;
    this.nilai = nilai;
    this.nilaiMean = nilaiMean;
    this.siswa = siswa;
  }

  public int getIdNilai(){
    return idNilai;
  }

  public void setIdNilai(int idNilai){
    this.idNilai = idNilai;
  }

  public double getNilai(){
    return nilai;
  }

  public void setNilai(double nilai){
    this.nilai = nilai;
  }

  public double getNilaiMean(){
    return nilaiMean;
  }

  public void setNilaiMean(double nilaiMean){
    this.nilaiMean = nilaiMean;
  }

  public Siswa getSiswa(){
    return siswa;
  }

  public void setSiswa(Siswa siswa){
    this.siswa = siswa;
  }
  
}
