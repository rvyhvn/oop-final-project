package com.project.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import com.project.model.Kelas;
import com.project.model.Laporan;
/**
 * Guru
 */
public class Guru extends Entity {

  private int idGuru;
  private Kelas kelas;
  private Laporan laporan;

  public Guru(int idGuru, String nama, String email, String phone, Kelas kelas, Laporan laporan) {
    super(nama, email, phone);
    this.idGuru = idGuru;
    this.kelas = kelas;
    this.laporan = laporan;
  }

  public Guru() {
    super("", "", "");
    this.idGuru = 0;
    this.kelas = kelas;
    this.laporan = laporan;
  }

  public int getIdGuru(){
    return idGuru;
  }

  public void setIdGuru(int idGuru){
    this.idGuru = idGuru;
  }

  public Kelas getKelas(){
    return kelas;
  }

  public void setKelas(Kelas kelas){
    this.kelas = kelas;
  }

  public Laporan getLaporan(){
    return laporan;
  }

  public void setLaporan(Laporan laporan){
    this.laporan = laporan;
  }
}
