package lasilu.controller;

import lasilu.dao.WaliMuridDAO;
import lasilu.model.Siswa;
import lasilu.model.WaliMurid;
import lasilu.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class WaliMuridController {
    private WaliMuridDAO waliMuridDAO;
    private Connection connection;

    public WaliMuridController(Connection connection) {
        waliMuridDAO = new WaliMuridDAO(connection); // Menginisialisasi objek WaliMuridDAO
    }


    public List<WaliMurid> getAllWaliMurid() {
      try {
        return waliMuridDAO.getAllWaliMurid();
      } catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
    }

    public WaliMurid getWaliMuridById(int idWali) {
        try {
            return waliMuridDAO.getWaliMuridById(idWali);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public WaliMurid getWaliMuridBySiswaId(int idSiswa) {
      try {
        List<WaliMurid> waliMuridList = waliMuridDAO.getWaliMuridBySiswaId(idSiswa);
        return waliMuridList.isEmpty() ? null : waliMuridList.get(0);
      } catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
    }

    public void addWaliMurid(String nama, String email, String phone, int idSiswa) {
        try {
          WaliMurid waliMurid = new WaliMurid();
          waliMurid.setNama(nama);
          waliMurid.setEmail(email);
          waliMurid.setPhone(phone);

          Siswa anak = new Siswa();
          anak.setIdSiswa(idSiswa);
          waliMurid.setAnak(anak);

          waliMuridDAO.addWaliMurid(waliMurid);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWaliMurid(int idWali, String nama, String email, String phone, int idSiswa) {
        try {
            WaliMurid waliMurid = new WaliMurid();
            waliMurid.setIdWali(idWali);
            waliMurid.setNama(nama);
            waliMurid.setEmail(email);
            waliMurid.setPhone(phone);

            Siswa anak = new Siswa();
            anak.setIdSiswa(idSiswa);
            waliMurid.setAnak(anak);

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

    public List<String> getEmailsWaliMurid(int idKelas) throws SQLException {
      try {
        return waliMuridDAO.getEmailsWaliMurid(idKelas);
      } catch (SQLException e) {
        e.printStackTrace();
        return null;
      }
    } 

}
