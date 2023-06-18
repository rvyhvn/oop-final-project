package com.project.controller;

import com.project.dao.SiswaDAO;
import com.project.model.*;
import com.project.model.WaliMurid;
import com.project.util.DatabaseUtil;

import com.project.controller.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SiswaController {
    private SiswaDAO siswaDAO;
    private Connection connection; 

    public SiswaController(Connection connection) {
        siswaDAO = new SiswaDAO(connection);
    }

    public List<Siswa> getAllSiswa() {
        try {
            return siswaDAO.getAllSiswa();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Siswa getSiswaById(int idSiswa) {
        try {
            return siswaDAO.getSiswaById(idSiswa);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addSiswa(String nama, String email, String phone, int idKelas, int idWali) {
        try {
            siswaDAO.addSiswa(createSiswa(nama, email, phone, idKelas, idWali));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSiswa(int idSiswa, String nama, String email, String phone, int idKelas, int idWali) {
        try {
            siswaDAO.updateSiswa(createSiswa(idSiswa, nama, email, phone, idKelas, idWali));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSiswa(int idSiswa) {
        try {
            siswaDAO.deleteSiswa(idSiswa);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Siswa createSiswa(String nama, String email, String phone, int idKelas, int idWali) {
        Siswa siswa = new Siswa();
        siswa.setNama(nama);
        siswa.setEmail(email);
        siswa.setPhone(phone);

        KelasController kelasController = new KelasController(connection);
        Kelas kelas = kelasController.getKelasById(idKelas);
        if (kelas == null) {
            System.out.println("Kelas dengan ID " + idKelas + " tidak ditemukan.");
            return null;
        }
        siswa.setKelas(kelas);

        WaliMuridController waliMuridController = new WaliMuridController(connection);
        WaliMurid waliMurid = waliMuridController.getWaliMuridById(idWali);
        if (waliMurid == null) {
            System.out.println("Wali Murid dengan ID " + idWali + " tidak ditemukan.");
            return null;
        }
        siswa.setWaliMurid(waliMurid);

        return siswa;
    }

    private Siswa createSiswa(int idSiswa, String nama, String email, String phone, int idKelas, int idWali) {
        Siswa siswa = createSiswa(nama, email, phone, idKelas, idWali);
        if (siswa != null) {
            siswa.setIdSiswa(idSiswa);
        }
        return siswa;
    }
}
