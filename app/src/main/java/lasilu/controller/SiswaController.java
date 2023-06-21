package lasilu.controller;

import lasilu.dao.SiswaDAO;
import lasilu.model.Kelas;
import lasilu.model.Nilai;
import lasilu.model.Siswa;
import lasilu.model.WaliMurid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SiswaController {
    private SiswaDAO siswaDAO;

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

    public List<Siswa> getSiswaByKelasId(int idKelas) {
        try {
            return siswaDAO.getSiswaByKelasId(idKelas);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addSiswa(String nama, String email, String phone, int idWali, int idKelas, int idNilai) {
        try {
            Siswa siswa = new Siswa();
            siswa.setNama(nama);
            siswa.setEmail(email);
            siswa.setPhone(phone);

            WaliMurid waliMurid = new WaliMurid();
            waliMurid.setIdWali(idWali);
            siswa.setWaliMurid(waliMurid);

            Kelas kelas = new Kelas();
            kelas.setIdKelas(idKelas);
            siswa.setKelas(kelas);

            Nilai nilaiMean = new Nilai();
            nilaiMean.setIdNilai(idNilai);
            siswa.setNilaiMean(nilaiMean);

            siswaDAO.addSiswa(siswa);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSiswa(int idSiswa, String nama, String email, String phone, int idWali, int idKelas,
            int idNilai) {
        try {
            Siswa siswa = new Siswa();
            siswa.setIdSiswa(idSiswa);
            siswa.setNama(nama);
            siswa.setEmail(email);
            siswa.setPhone(phone);

            WaliMurid waliMurid = new WaliMurid();
            waliMurid.setIdWali(idWali);
            siswa.setWaliMurid(waliMurid);

            Kelas kelas = new Kelas();
            kelas.setIdKelas(idKelas);
            siswa.setKelas(kelas);

            Nilai nilaiMean = new Nilai();
            nilaiMean.setIdNilai(idNilai);
            siswa.setNilaiMean(nilaiMean);
            siswaDAO.updateSiswa(siswa);
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
}
