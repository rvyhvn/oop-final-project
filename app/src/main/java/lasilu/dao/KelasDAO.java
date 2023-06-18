package com.project.dao;

import com.project.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KelasDAO {
    private Connection connection;

    public KelasDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Kelas> getAllKelas() throws SQLException {
        List<Kelas> kelasList = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kelas");
            while (resultSet.next()) {
                Kelas kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setNamaKelas(resultSet.getString("nama_kelas"));
                // Set properties lainnya sesuai dengan kolom-kolom yang ada dalam tabel
                kelasList.add(kelas);
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
            connection.close();
        }
        return kelasList;
    }

    public Kelas getKelasById(int idKelas) throws SQLException {
        Kelas kelas = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM kelas WHERE id_kelas = ?");
            statement.setInt(1, idKelas);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                kelas = new Kelas();
                kelas.setIdKelas(resultSet.getInt("id_kelas"));
                kelas.setNamaKelas(resultSet.getString("nama_kelas"));
                // Set properties lainnya sesuai dengan kolom-kolom yang ada dalam tabel
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
            connection.close();
        }
        return kelas;
    }

    public void addKelas(Kelas kelas) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO kelas (nama_kelas) VALUES (?)");
            statement.setString(1, kelas.getNamaKelas());
            // Set properties lainnya sesuai dengan kolom-kolom yang ada dalam tabel
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
            connection.close();
        }
    }

    public void updateKelas(Kelas kelas) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE kelas SET nama_kelas = ? WHERE id_kelas = ?");
            statement.setString(1, kelas.getNamaKelas());
            // Set properties lainnya sesuai dengan kolom-kolom yang ada dalam tabel
            statement.setInt(2, kelas.getIdKelas());
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
            connection.close();
        }
    }

    public void deleteKelas(int idKelas) throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM kelas WHERE id_kelas = ?");
            statement.setInt(1, idKelas);
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
            connection.close();
        }
    }
}
