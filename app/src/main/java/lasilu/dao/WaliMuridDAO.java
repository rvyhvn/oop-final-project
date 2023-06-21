package lasilu.dao;

import lasilu.model.WaliMurid;
import lasilu.model.Siswa;
import lasilu.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaliMuridDAO {
    private Connection connection;

    // Constructor
    public WaliMuridDAO(Connection connection) {
        this.connection = connection;
    }

    public List<WaliMurid> getAllWaliMurid() throws SQLException {
        List<WaliMurid> waliMuridList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM walimurid;";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                WaliMurid waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("id_wali"));
                waliMurid.setNama(resultSet.getString("nama"));
                waliMurid.setEmail(resultSet.getString("email"));
                waliMurid.setPhone(resultSet.getString("phone"));

                Siswa anak = new Siswa();
                anak.setIdSiswa(resultSet.getInt("siswa_id"));
                // siswa.setNama(resultSet.getString("nama"));
                // siswa.setEmail(resultSet.getString("email"));
                // siswa.setPhone(resultSet.getString("phone"));

                waliMurid.setAnak(anak);
                waliMuridList.add(waliMurid);
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
          } catch (SQLException e){
            e.printStackTrace();
          }
        }
    }
    return waliMuridList;
  }
    public WaliMurid getWaliMuridById(int idWali) throws SQLException {
        WaliMurid waliMurid = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM walimurid WHERE id_wali = ?;";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idWali);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("id_wali"));
                waliMurid.setNama(resultSet.getString("nama"));
                waliMurid.setEmail(resultSet.getString("email"));
                waliMurid.setPhone(resultSet.getString("phone"));

                Siswa anak = new Siswa();
                anak.setIdSiswa(resultSet.getInt("siswa_id"));
                anak.setNama(resultSet.getString("nama"));
                anak.setEmail(resultSet.getString("email"));
                anak.setPhone(resultSet.getString("phone"));

                waliMurid.setAnak(anak);
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
        return waliMurid;
    }


  public List<WaliMurid> getWaliMuridBySiswaId(int idSiswa) throws SQLException {
      List<WaliMurid> waliMuridList = new ArrayList<>();
      PreparedStatement statement = null;
      ResultSet resultSet = null;

      try {
          String query = "SELECT * FROM walimurid WHERE siswa_id = ?";
          statement = connection.prepareStatement(query);
          statement.setInt(1, idSiswa);
          resultSet = statement.executeQuery();

          while (resultSet.next()) {
              WaliMurid waliMurid = new WaliMurid();
              waliMurid.setIdWali(resultSet.getInt("id_wali"));
              waliMurid.setNama(resultSet.getString("nama"));
              waliMurid.setEmail(resultSet.getString("email"));
              waliMurid.setPhone(resultSet.getString("phone"));

              Siswa anak = new Siswa();
              anak.setIdSiswa(resultSet.getInt("siswa_id"));
              anak.setNama(resultSet.getString("nama"));
              anak.setEmail(resultSet.getString("email"));
              anak.setPhone(resultSet.getString("phone"));

              waliMurid.setAnak(anak);

              waliMuridList.add(waliMurid);
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
      return waliMuridList;
  }


    public void addWaliMurid(WaliMurid waliMurid) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO wali_murid (nama, email, phone) VALUES (?, ?, ?);";
            statement = connection.prepareStatement(query);
            statement.setString(1, waliMurid.getNama());
            statement.setString(2, waliMurid.getEmail());
            statement.setString(3, waliMurid.getPhone());
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

    public void updateWaliMurid(WaliMurid waliMurid) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE wali_murid SET nama = ?, email = ?, phone = ? WHERE id_wali = ?;";
            statement = connection.prepareStatement(query);
            statement.setString(1, waliMurid.getNama());
            statement.setString(2, waliMurid.getEmail());
            statement.setString(3, waliMurid.getPhone());
            statement.setInt(4, waliMurid.getIdWali());
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

    public void deleteWaliMurid(int idWali) throws SQLException {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM wali_murid WHERE id_wali = ?;";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idWali);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
        }
    }

  public List<String> getEmailsWaliMurid(int idKelas) throws SQLException {
      List<String> emails = new ArrayList<>();
      PreparedStatement statement = null;
      ResultSet resultSet = null;
      try {
          String query = "SELECT walimurid.email FROM walimurid JOIN siswa ON walimurid.siswa_id = siswa.id_siswa WHERE siswa.kelas_id = ?;";
          statement = connection.prepareStatement(query);
          statement.setInt(1, idKelas);
          resultSet = statement.executeQuery();
          while (resultSet.next()) {
              String email = resultSet.getString("email");
              emails.add(email);
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
      return emails;
  }
}
