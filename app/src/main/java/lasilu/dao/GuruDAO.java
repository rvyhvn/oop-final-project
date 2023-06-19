package lasilu.dao;

import lasilu.model.*;
import lasilu.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuruDAO {
    private Connection connection;

    // Constructor
    public GuruDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Guru> getAllGuru() throws SQLException {
        List<Guru> guruList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
          String query = "SELECT * FROM guru";
          statement = connection.prepareStatement(query);
          resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Guru guru = new Guru();
                guru.setIdGuru(resultSet.getInt("id_guru"));
                guru.setNama(resultSet.getString("nama"));
                guru.setEmail(resultSet.getString("email"));
                guru.setPhone(resultSet.getString("phone"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                guru.setKelas(kelas);
                guruList.add(guru);
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
        return guruList;
    }

    public List<Guru> getGuruById(int idGuru) throws SQLException {
        List<Guru> guruList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM guru WHERE id_guru = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idGuru);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Guru guru = new Guru();
                guru.setIdGuru(resultSet.getInt("id_guru"));
                guru.setNama(resultSet.getString("nama"));
                guru.setEmail(resultSet.getString("email"));
                guru.setPhone(resultSet.getString("phone"));

                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setTingkat(resultSet.getString("tingkat"));
                kelas.setUrutan(resultSet.getInt("urutan"));
                kelas.setIsIpa(resultSet.getBoolean("is_ipa"));

                guru.setKelas(kelas);
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
        return guruList;
    }

    public void addGuru(Guru guru) throws SQLException {
        PreparedStatement statement = null;
        try {
          String query = "INSERT INTO guru (nama, phone, email, kelas_id, mapel_id, password) VALUES (?, ?, ?, ?, ?, ?)";
          statement = connection.prepareStatement(query);
            statement.setString(1, guru.getNama());
            statement.setString(2, guru.getEmail());
            statement.setString(3, guru.getPhone());
            statement.setInt(4, guru.getKelas().getIdKelas());
            statement.setInt(5, guru.getMapel().getIdMapel());
            statement.setString(6, guru.getPassword());
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

    public void updateGuru(Guru guru) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE guru SET nama = ?, email = ?, phone = ?, kelas_id = ? mapel_id = ?, password = ? WHERE id_guru = ?;");
            statement.setString(1, guru.getNama());
            statement.setString(2, guru.getEmail());
            statement.setString(3, guru.getPhone());
            statement.setInt(4, guru.getKelas().getIdKelas());
            statement.setInt(5, guru.getMapel().getIdMapel());
            statement.setString(6, guru.getPassword());
            statement.setInt(7, guru.getIdGuru());
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

    public void deleteGuru(int idGuru) throws SQLException {
        PreparedStatement statement = null;
        try {
          String query = "DELETE FROM guru WHERE id_guru = ?";
          statement = connection.prepareStatement(query);
          statement.setInt(1, idGuru);
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
