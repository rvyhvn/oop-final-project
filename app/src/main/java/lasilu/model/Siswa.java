package com.project.model;

import java.sql.*;
import java.util.*;


/**
 * Siswa
 */
public class Siswa extends Entity {

  private int idSiswa;
  private Kelas kelas;
  private WaliMurid waliMurid;
  private Nilai nilaiMean;

  public Siswa() {

  }

  public Siswa(int idSiswa, String nama, Kelas kelas, String email, String phone, WaliMurid waliMurid, Nilai nilaiMean) {
    super(nama, email, phone);
    this.idSiswa = idSiswa;
    this.kelas = kelas;
    this.waliMurid = waliMurid;
    this.nilaiMean = nilaiMean;
  }

  public int getIdSiswa() {
    return idSiswa;
  }

  public Kelas getKelas() {
    return kelas; 
  }

  public WaliMurid getWaliMurid() {
    return waliMurid;
  }

  public Nilai getNilaiMean() {
    return nilaiMean;
  }
  
  public void setIdSiswa(int idSiswa) {
    this.idSiswa = idSiswa;
  }
  public void setKelas(Kelas kelas) {
    this.kelas = kelas;
  }

  public void setWaliMurid(WaliMurid waliMurid) {
    this.waliMurid = waliMurid;
  }

  public void setNilaiMean(Nilai nilaiMean) {
    this.nilaiMean = nilaiMean;
  }

} 
  

