package lasilu.controller;

import lasilu.dao.MataPelajaranDAO;
import lasilu.model.Kelas;
import lasilu.model.MataPelajaran;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class MataPelajaranController {
  private MataPelajaranDAO mataPelajaranDAO;

  public MataPelajaranController(Connection connection) {
    mataPelajaranDAO = new MataPelajaranDAO(connection);
  }

  public List<MataPelajaran> getAllMataPelajaran() throws SQLException {
    try {
      return mataPelajaranDAO.getAllMataPelajaran();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

  }

  public MataPelajaran getMapelById(int idMapel) {
    try {
      return mataPelajaranDAO.getMapelById(idMapel);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void addMataPelajaran(String namaMapel, String jurusan, int idKelas) {
    try {
      MataPelajaran mataPelajaran = new MataPelajaran();
      mataPelajaran.setNamaMapel(namaMapel);
      mataPelajaran.setJurusan(jurusan);

      Kelas kelas = new Kelas();
      kelas.setIdKelas(idKelas);
      mataPelajaran.setKelas(kelas);

      mataPelajaranDAO.addMataPelajaran(mataPelajaran);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void updateMataPelajaran(int idMapel, String namaMapel, String jurusan, int idKelas) {
    try {
      MataPelajaran mataPelajaran = new MataPelajaran();
      mataPelajaran.setIdMapel(idMapel);
      mataPelajaran.setNamaMapel(namaMapel);
      mataPelajaran.setJurusan(jurusan);

      Kelas kelas = new Kelas();
      kelas.setIdKelas(idKelas);
      mataPelajaran.setKelas(kelas);

      mataPelajaranDAO.updateMataPelajaran(mataPelajaran);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void deleteMataPelajaran(int idMapel) {
    try {
      mataPelajaranDAO.deleteMataPelajaran(idMapel);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
