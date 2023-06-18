package com.project.model;

import java.util.ArrayList;
import com.project.model.MataPelajaran;
import com.project.model.Kelas;

/**
 * MapelKelas
 */
public class MapelKelas {

  private int idMapelKelas;
  private MataPelajaran mapel;
  private Kelas kelas;

  public MapelKelas() {

  }

  public MapelKelas(int idMapelKelas, MataPelajaran mapel, Kelas kelas) {
    this.idMapelKelas = idMapelKelas;
    this.mapel = mapel;
    this.kelas = kelas;
  }

  public int getIdMapelKelas(){
    return idMapelKelas;
  }

  public MataPelajaran getMapel(){
    return mapel;
  }

  public Kelas getKelas(){
    return kelas;
  }
  
  public void setIdMapelKelas(int idMapelKelas){
    this.idMapelKelas = idMapelKelas;
  }

  public void setMapel(MataPelajaran mapel){
    this.mapel = mapel;
  }

  public void setKelas(Kelas kelas){
    this.kelas = kelas;
  }
}
