package com.project.dao;

import com.project.model.WaliMurid;
import com.project.model.Siswa;
import com.project.util.DatabaseUtil;

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
            String query = "SELECT wm.id_wali, wm.nama, wm.email, wm.phone, s.id_siswa, s.nama AS nama_siswa, s.email AS email_siswa, s.phone AS phone_siswa " +
                           "FROM wali_murid wm LEFT JOIN siswa s ON wm.id_wali = s.id_wali;";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                WaliMurid waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("id_wali"));
                waliMurid.setNama(resultSet.getString("nama"));
                waliMurid.setEmail(resultSet.getString("email"));
                waliMurid.setPhone(resultSet.getString("phone"));

                Siswa siswa = new Siswa();
                siswa.setIdSiswa(resultSet.getInt("id_siswa"));
                siswa.setNama(resultSet.getString("nama_siswa"));
                siswa.setEmail(resultSet.getString("email_siswa"));
                siswa.setPhone(resultSet.getString("phone_siswa"));

                waliMurid.setAnak(null);

                waliMuridList.add(waliMurid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection(connection);
        }
        return waliMuridList;
    }

    public WaliMurid getWaliMuridById(int idWali) throws SQLException {
        WaliMurid waliMurid = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT wm.id_wali, wm.nama, wm.email, wm.phone, s.id_siswa, s.nama AS nama_siswa, s.email AS email_siswa, s.phone AS phone_siswa " +
                           "FROM wali_murid wm LEFT JOIN siswa s ON wm.id_wali = s.id_wali WHERE wm.id_wali = ?;";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idWali);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                waliMurid = new WaliMurid();
                waliMurid.setIdWali(resultSet.getInt("id_wali"));
                waliMurid.setNama(resultSet.getString("nama"));
                waliMurid.setEmail(resultSet.getString("email"));
                waliMurid.setPhone(resultSet.getString("phone"));

                Siswa siswa = new Siswa();
                siswa.setIdSiswa(resultSet.getInt("id_siswa"));
                siswa.setNama(resultSet.getString("nama_siswa"));
                siswa.setEmail(resultSet.getString("email_siswa"));
                siswa.setPhone(resultSet.getString("phone_siswa"));

                waliMurid.setAnak(null);;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeConnection(connection);
        }
        return waliMurid;
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
            DatabaseUtil.closeConnection(connection);
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
            DatabaseUtil.closeConnection(connection);
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
            DatabaseUtil.closeConnection(connection);
        }
    }
}
