package com.project.dao;

import com.project.model.Nilai;
import com.project.model.Siswa;

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

    public void addNilai(Nilai nilai) {
        String query = "INSERT INTO nilai (id_nilai, nilai, nilai_mean) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, nilai.getIdNilai());
            statement.setDouble(2, nilai.getNilai());
            statement.setDouble(3, nilai.getNilaiMean());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Nilai getNilaiById(int idNilai) {
        String query = "SELECT * FROM nilai WHERE id_nilai = ?";
        Nilai nilai = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idNilai);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    nilai = mapResultSetToNilai(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nilai;
    }

    public List<Nilai> getAllNilai() {
        String query = "SELECT * FROM nilai";
        List<Nilai> nilaiList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Nilai nilai = mapResultSetToNilai(resultSet);
                nilaiList.add(nilai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nilaiList;
    }

    private Nilai mapResultSetToNilai(ResultSet resultSet) throws SQLException {
        int idNilai = resultSet.getInt("id_nilai");
        double nilai = resultSet.getDouble("nilai");
        double nilaiMean = resultSet.getDouble("nilai_mean");

        return new Nilai(idNilai, nilai, nilaiMean);
    }
}
