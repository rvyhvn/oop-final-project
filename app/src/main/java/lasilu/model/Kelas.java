package com.project.model;

import com.project.dao.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Kelas
 */
public class Kelas {

  private int idKelas;
  private String tingkat;
  private int urutan;
  private boolean isIpa;
  private String namaKelas;
  private ArrayList<Guru> guru;
  private ArrayList<Siswa> siswa;
  private ArrayList<MataPelajaran> mapel;

  public Kelas() {

  }

  public Kelas(int idKelas, String tingkat, int urutan, boolean isIpa, String namaKelas, ArrayList<Guru> guru, ArrayList<Siswa> siswa, ArrayList<MataPelajaran> mapel) {
    this.idKelas = idKelas;
    this.tingkat = tingkat;
    this.urutan = urutan;
    this.isIpa = isIpa;
    this.namaKelas = namaKelas;
    this.guru = guru;
    this.siswa = siswa;
    this.mapel = mapel;
  }

  public int getIdKelas(){
    return idKelas;
  }

  public String getTingkat(){
    return tingkat;
  }

  public int getUrutan(){
    return urutan;
  }

  public boolean getIsIpa(){
    return isIpa;
  }

  public String getNamaKelas(){
    String namaKelas = tingkat + " ";
    if (isIpa) {
      namaKelas += "IPA";
    } else {
      namaKelas += "IPS";
    }
    namaKelas += urutan;

    return namaKelas;
  }

  public ArrayList<Guru> getGuru(){
    return guru; 
  }

  public ArrayList<Siswa> getSiswa(){
    return siswa;
  }

  public ArrayList<MataPelajaran> getMapel(){
    return mapel;
  }

  public void setIdKelas(int idKelas){
    this.idKelas = idKelas;
  }

  public void setTingkat(String tingkat){
    this.tingkat = tingkat;
  }

  public void setUrutan(int urutan){
    this.urutan = urutan;
  }

  public void setIsIpa(boolean isIpa){
    this.isIpa = isIpa;
  }

  public void setNamaKelas(String namaKelas) {
      // Mengurai namaKelas menjadi tingkat, jurusan, dan urutan
      String[] parts = namaKelas.split(" ");
      tingkat = parts[0];

      if (parts[1].equalsIgnoreCase("IPA")) {
          isIpa = true;
      } else {
          isIpa = false;
      }

      urutan = Integer.parseInt(parts[2]);
  }
  public void setGuru(ArrayList<Guru> guru){
    this.guru = guru;
  }

  public void setSiswa(ArrayList<Siswa> siswa){
    this.siswa = siswa;
  }

  public void setMapel(ArrayList<MataPelajaran> mapel){
    this.mapel = mapel;
  }
}
