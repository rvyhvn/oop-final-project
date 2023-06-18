package com.project.model;

import java.util.ArrayList;

/**
 * MataPelajaran
 */
public class MataPelajaran {
  
  private int idMapel;
  private String namaMapel;
  private ArrayList<Kelas> kelas;

  public MataPelajaran() {

  }

  public MataPelajaran(int idMapel, String namaMapel, ArrayList<Kelas> kelas) {
    this.idMapel = idMapel;
    this.namaMapel = namaMapel;
    this.kelas = kelas;
  }

  public int getIdMapel(){
    return idMapel;
  }

  public void setIdMapel(int idMapel){
    this.idMapel = idMapel;
  }

  public String getNamaMapel(){
    return namaMapel;
  }

  public void setNamaMapel(String namaMapel){
    this.namaMapel = namaMapel;
  }

  public ArrayList<Kelas> getKelas(){
    return kelas;
  }

  public void setKelas(ArrayList<Kelas> kelas){
    this.kelas = kelas;
  }
}
