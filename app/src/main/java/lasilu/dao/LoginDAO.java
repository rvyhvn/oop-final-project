package com.project.dao;

import com.project.model.Guru;
import com.project.model.Kelas;
import com.project.model.Laporan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAO {
    private Connection connection;

    public LoginDAO(Connection connection) {
        this.connection = connection;
    }

    public Guru login(String email, String password) throws SQLException {
        String query = "SELECT * FROM guru WHERE email = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idGuru = resultSet.getInt("id_guru");
                String nama = resultSet.getString("nama");
                String phone = resultSet.getString("phone");

                Guru guru = new Guru(idGuru, nama, email, phone, null, null);
                return guru;
            }
        }
        return null;
    }
}
