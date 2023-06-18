package com.project.controller;

import com.project.dao.WaliMuridDAO;
import com.project.model.WaliMurid;
import com.project.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class WaliMuridController {
    private WaliMuridDAO waliMuridDAO;
    private Connection connection;

    // Constructor
    public WaliMuridController(Connection connection) {
        waliMuridDAO = new WaliMuridDAO(connection); // Menginisialisasi objek WaliMuridDAO
    }


    public List<WaliMurid> getAllWaliMurid() {
        List<WaliMurid> waliMuridList = null;
        try {
            waliMuridList = waliMuridDAO.getAllWaliMurid();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return waliMuridList;
    }

    public WaliMurid getWaliMuridById(int idWali) {
        WaliMurid waliMurid = null;
        try {
            waliMurid = waliMuridDAO.getWaliMuridById(idWali);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return waliMurid;
    }

    public void addWaliMurid(WaliMurid waliMurid) {
        try {
            waliMuridDAO.addWaliMurid(waliMurid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWaliMurid(WaliMurid waliMurid) {
        try {
            waliMuridDAO.updateWaliMurid(waliMurid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteWaliMurid(int idWali) {
        try {
            waliMuridDAO.deleteWaliMurid(idWali);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        DatabaseUtil.closeConnection(connection);
    }
}
