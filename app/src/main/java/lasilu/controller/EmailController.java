package lasilu.controller;

import lasilu.dao.WaliMuridDAO;
import lasilu.model.Email;
import lasilu.model.WaliMurid;
import lasilu.util.DatabaseUtil;
import lasilu.util.EmailUtil;
import lasilu.controller.WaliMuridController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailController {
    private EmailUtil emailUtil;
    private WaliMuridController waliMuridController;

    public EmailController(WaliMuridDAO waliMuridDAO, EmailUtil emailUtil) throws SQLException {
      this.emailUtil = emailUtil;
    }

    public EmailController() throws SQLException {
        // Membuat koneksi ke database
        Connection connection = DatabaseUtil.getConnection();
        // Membuat instance WaliMuridDAO
        waliMuridController = new WaliMuridController(connection);
    }

    public void sendEmailToWaliMurid(int idKelas, String emailSender, String subject, String body, String attachmentPath) {
        try {
            // Mendapatkan daftar email wali murid berdasarkan kelasId
            List<String> recipients = waliMuridController.getEmailsWaliMurid(idKelas);

            // Membuat instance Email
            Email email = new Email();
            email.setEMAIL_SENDER(emailSender);
            email.setRecipients(recipients);
            email.setSubject(subject);
            email.setBody(body);
            email.setAttachmentPath(attachmentPath);

            // Proses pengiriman email
            sendEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sendEmail(Email email) {
        // Menggunakan EmailUtil untuk mengirim email
        EmailUtil.sendEmail(email);
    }
}
