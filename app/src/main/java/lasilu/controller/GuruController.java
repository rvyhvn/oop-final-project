package com.project.controller;

import com.project.dao.*;
import com.project.model.*;
import java.sql.*;
import java.util.List;

public class GuruController {
    
  private GuruDAO guruDAO;
  private Connection connection;

  public GuruController() {
      guruDAO = new GuruDAO(connection);
  }

  public void tambahGuru(Guru guru) {
      try {
          guruDAO.addGuru(guru);
          System.out.println("Guru berhasil ditambahkan.");
      } catch (SQLException e) {
          System.out.println("Gagal menambahkan guru: " + e.getMessage());
      }
  }

  public void updateGuru(Guru guru) {
      try {
          guruDAO.updateGuru(guru);
          System.out.println("Data guru berhasil diperbarui.");
      } catch (SQLException e) {
          System.out.println("Gagal memperbarui data guru: " + e.getMessage());
      }
  }

  public void hapusGuru(int idGuru) {
      try {
          guruDAO.deleteGuru(idGuru);
          System.out.println("Guru berhasil dihapus.");
      } catch (SQLException e) {
          System.out.println("Gagal menghapus guru: " + e.getMessage());
      }
  }

  public List<Guru> getDaftarGuru() {
      try {
          return guruDAO.getAllGuru();
      } catch (SQLException e) {
          System.out.println("Gagal mengambil daftar guru: " + e.getMessage());
          return null;
      }
  }

  public Guru getGuruById(int idGuru) {
      try {
          return guruDAO.getGuruById(idGuru);
      } catch (SQLException e) {
          System.out.println("Gagal mengambil data guru: " + e.getMessage());
          return null;
      }
  }
}
