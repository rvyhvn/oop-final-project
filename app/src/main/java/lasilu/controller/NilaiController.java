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

   public List<Nilai> getAllNilai() throws SQLException {
        return nilaiDAO.getAllNilai();
    }

}
