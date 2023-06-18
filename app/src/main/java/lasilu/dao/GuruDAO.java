package com.project.dao;

import com.project.model.*;
import com.project.util.DatabaseUtil;

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
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT g.id_guru, g.nama, g.email, g.phone, k.id_kelas, k.tingkat, k.urutan, k.is_ipa FROM guru g LEFT JOIN kelas k ON g.kelas_id = k.id_kelas;");
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
            DatabaseUtil.closeConnection(connection);
        }
        return guruList;
    }

    public Guru getGuruById(int idGuru) throws SQLException {
        Guru guru = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT g.id_guru, g.nama, g.email, g.phone, k.id_kelas, k.tingkat, k.urutan, k.is_ipa FROM guru g LEFT JOIN kelas k ON g.kelas_id = k.id_kelas WHERE g.id_guru = ?;");
            statement.setInt(1, idGuru);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                guru = new Guru();
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
            DatabaseUtil.closeConnection(connection);
        }
        return guru;
    }

    public void addGuru(Guru guru) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO guru (nama, email, phone, kelas_id) VALUES (?, ?, ?, ?);");
            statement.setString(1, guru.getNama());
            statement.setString(2, guru.getEmail());
            statement.setString(3, guru.getPhone());
            statement.setInt(4, guru.getKelas().getIdKelas());
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
            DatabaseUtil.closeConnection(connection);
        }
    }

    public void updateGuru(Guru guru) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE guru SET nama = ?, email = ?, phone = ?, kelas_id = ? WHERE id_guru = ?;");
            statement.setString(1, guru.getNama());
            statement.setString(2, guru.getEmail());
            statement.setString(3, guru.getPhone());
            statement.setInt(4, guru.getKelas().getIdKelas());
            statement.setInt(5, guru.getIdGuru());
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
            DatabaseUtil.closeConnection(connection);
        }
    }

    public void deleteGuru(int idGuru) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM guru WHERE id_guru = ?;");
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
            DatabaseUtil.closeConnection(connection);
        }
    }
}
