package lasilu.controller;

import lasilu.dao.WaliMuridDAO;
import lasilu.model.Email;
import lasilu.model.WaliMurid;
import lasilu.util.DatabaseUtil;
import lasilu.util.EmailUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailController {
    private WaliMuridDAO waliMuridDAO;
    private EmailUtil emailUtil;

    public EmailController(WaliMuridDAO waliMuridDAO, EmailUtil emailUtil) throws SQLException {
      this.waliMuridDAO = waliMuridDAO;
      this.emailUtil = emailUtil;
    }

    public EmailController() throws SQLException {
        // Membuat koneksi ke database
        Connection connection = DatabaseUtil.getConnection();
        // Membuat instance WaliMuridDAO
        waliMuridDAO = new WaliMuridDAO(connection);
    }

    public void sendEmailToWaliMurid(int idKelas, String EMAIL_SENDER, String subject, String body, String attachmentPath) {
        try {
            // Mendapatkan daftar email wali murid berdasarkan kelasId
            List<String> recipients = getEmailsWaliMurid(idKelas);

            // Membuat instance Email
            Email email = new Email(EMAIL_SENDER, subject, body, recipients, attachmentPath);

            // Proses pengiriman email
            sendEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<String> getEmailsWaliMurid(int idKelas) throws SQLException {
        // Mendapatkan daftar wali murid berdasarkan kelasId
        List<WaliMurid> waliMuridList = new ArrayList<>();
        waliMuridList = waliMuridDAO.getWaliMuridBySiswaId(idKelas);

        // Menyimpan email wali murid ke dalam List
        List<String> recipients = new ArrayList<>();
        for (WaliMurid waliMurid : waliMuridList) {
            recipients.add(waliMurid.getEmail());
        }

        return recipients;
    }

    private void sendEmail(Email email) {
        // Menggunakan EmailUtil untuk mengirim email
        EmailUtil.sendEmail(email);
    }
}
