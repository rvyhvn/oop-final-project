package com.project.model;

import java.util.ArrayList;

/**
 * Nilai
 */
public class Nilai {

  private int idNilai;
  private double nilai;
  private double nilaiMean;
  private ArrayList<Siswa> siswaList;

  public Nilai() {

  }

  public Nilai(int idNilai, double nilai, double nilaiMean) {
    this.idNilai = idNilai;
    this.nilai = nilai;
    this.nilaiMean = nilaiMean;
    this.siswaList = new ArrayList<>();
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

  public ArrayList<Siswa> getSiswaList(){
    return siswaList;
  }

  public void setSiswaList(ArrayList<Siswa> siswaList){
    this.siswaList = siswaList;
  }
  
  public void addSiswa(Siswa siswa){
    siswaList.add(siswa);
  }

  public void removeSiswa(Siswa siswa){
    siswaList.remove(siswa);
  }

}
