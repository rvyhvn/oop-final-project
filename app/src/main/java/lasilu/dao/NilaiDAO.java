package lasilu.dao;

import lasilu.model.Nilai;
import lasilu.model.Siswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NilaiDAO {
  private Connection connection;

  public NilaiDAO(Connection connection) {
    this.connection = connection;
  }

  public List<Nilai> getAllNilai() throws SQLException {
    List<Nilai> nilaiList = new ArrayList<>();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      String query = "SELECT * FROM nilai";
      statement = connection.prepareStatement(query);
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Nilai nilai = new Nilai();
        nilai.setIdNilai(resultSet.getInt("id_nilai"));
        nilai.setNilaiMean(resultSet.getDouble("mean"));

        Siswa siswa = new Siswa();
        siswa.setIdSiswa(resultSet.getInt("id_siswa"));
        nilai.setSiswa(siswa);

        nilaiList.add(nilai);

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
    return nilaiList;
  }

}
