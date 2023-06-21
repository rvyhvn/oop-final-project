package lasilu.dao;

import lasilu.model.Kelas;
import lasilu.model.MataPelajaran;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MataPelajaranDAO {
  private Connection connection;

  public MataPelajaranDAO(Connection connection) {
    this.connection = connection;
  }

  public List<MataPelajaran> getAllMataPelajaran() throws SQLException {
    List<MataPelajaran> mapelList = new ArrayList<>();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      String query = "SELECT * FROM mapel";
      statement = connection.prepareStatement(query);
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        MataPelajaran mataPelajaran = new MataPelajaran();
        mataPelajaran.setIdMapel(resultSet.getInt("id_mapel"));
        mataPelajaran.setNamaMapel(resultSet.getString("nama_mapel"));

        Kelas kelas = new Kelas();
        kelas.setIdKelas(resultSet.getInt("kelas_id"));
        mataPelajaran.setKelas(kelas);

        mapelList.add(mataPelajaran);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return mapelList;
  }

  public MataPelajaran getMapelById(int idMapel) throws SQLException {
    MataPelajaran mataPelajaran = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      String query = "SELECT * FROM mapel WHERE id_mapel = ?";
      statement = connection.prepareStatement(query);
      statement.setInt(1, idMapel);
      resultSet = statement.executeQuery();
      if (resultSet.next()) {
        mataPelajaran = new MataPelajaran();
        mataPelajaran.setIdMapel(resultSet.getInt("id_mapel"));
        mataPelajaran.setNamaMapel(resultSet.getString("nama_mapel"));

        Kelas kelas = new Kelas();
        kelas.setIdKelas(resultSet.getInt("kelas_id"));
        mataPelajaran.setKelas(kelas);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return mataPelajaran;
  }

  public void addMataPelajaran(MataPelajaran mataPelajaran) throws SQLException {
    PreparedStatement statement = null;
    try {
      String query = "INSERT INTO mapel (nama_mapel, jurusan, kelas_id) VALUES (?, ?, ?)";
      statement = connection.prepareStatement(query);
      statement.setString(1, mataPelajaran.getNamaMapel());
      statement.setString(2, mataPelajaran.getJurusan());
      statement.setInt(3, mataPelajaran.getKelas().getIdKelas());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void updateMataPelajaran(MataPelajaran mataPelajaran) throws SQLException {
    PreparedStatement statement = null;
    try {
      String query = "UPDATE mapel SET nama_mapel = ?, jurusan = ?, kelas_id = ? WHERE id_kelas = ?";
      statement = connection.prepareStatement(query);
      statement.setString(1, mataPelajaran.getNamaMapel());
      statement.setString(2, mataPelajaran.getJurusan());
      statement.setInt(3, mataPelajaran.getKelas().getIdKelas());
      statement.setInt(4, mataPelajaran.getIdMapel());
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void deleteMataPelajaran(int idMapel) throws SQLException {
    PreparedStatement statement = null;
    try {
      String query = "DELETE FROM mapel WHERE id_mapel = ?";
      statement = connection.prepareStatement(query);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
