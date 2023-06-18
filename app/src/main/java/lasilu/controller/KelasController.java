package com.project.controller;

import com.project.dao.KelasDAO;
import com.project.model.Kelas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class KelasController {
    private KelasDAO kelasDAO;

    public KelasController(Connection connection) {
        this.kelasDAO = new KelasDAO(connection);
    }

    public List<Kelas> getAllKelas() {
        try {
            return kelasDAO.getAllKelas();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Kelas getKelasById(int idKelas) {
        try {
            return kelasDAO.getKelasById(idKelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addKelas(Kelas kelas) {
        try {
            kelasDAO.addKelas(kelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateKelas(Kelas kelas) {
        try {
            kelasDAO.updateKelas(kelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKelas(int idKelas) {
        try {
            kelasDAO.deleteKelas(idKelas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
