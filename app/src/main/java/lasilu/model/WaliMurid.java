package com.project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WaliMurid extends Entity {
    private int idWali;
    private ArrayList<Siswa> anak;

    public WaliMurid() {

    }

    public WaliMurid(int idWali, String nama, String email, String phone, ArrayList<Siswa> anak) {
      super(nama, email, phone);
      this.idWali = idWali;
      this.anak = anak;
    }

    // Getter dan setter

    public int getIdWali() {
      return idWali;
    }

    public void setIdWali(int id) {
      this.idWali = id;
    }

    public ArrayList<Siswa> getAnak(){
      return anak;
    }

    public void setAnak(ArrayList<Siswa> anak){
      this.anak = anak;
    }

}
