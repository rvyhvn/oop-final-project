package lasilu.controller;

import lasilu.dao.NilaiDAO;
import lasilu.model.Nilai;
import lasilu.model.Siswa;
import lasilu.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NilaiController {
    private NilaiDAO nilaiDAO;

    public NilaiController() {
        try {
            Connection connection = DatabaseUtil.getConnection();
            nilaiDAO = new NilaiDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveNilai(Nilai nilai) {
        nilaiDAO.addNilai(nilai);
    }

    public Nilai getNilaiById(int idNilai) {
        return nilaiDAO.getNilaiById(idNilai);
    }

    public List<Nilai> getAllNilai() {
        return nilaiDAO.getAllNilai();
    }

    public void addSiswaToNilai(int idNilai, Siswa siswa) {
        Nilai nilai = nilaiDAO.getNilaiById(idNilai);
        if (nilai != null) {
            nilai.addSiswa(siswa);
            // Update nilai dengan siswa yang baru ditambahkan
            nilaiDAO.addNilai(nilai);
        }
    }
}
