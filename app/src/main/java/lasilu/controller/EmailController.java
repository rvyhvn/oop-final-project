package com.project.controller;

import com.project.dao.WaliMuridDAO;
import com.project.model.Email;
import com.project.model.WaliMurid;
import com.project.util.EmailUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailController {

    private WaliMuridDAO waliMuridDAO;

    public EmailController(WaliMuridDAO waliMuridDAO) {
        this.waliMuridDAO = waliMuridDAO;
    }

    public void sendEmailToRecipients(int waliMuridId, String subject, String body, String attachmentPath) throws SQLException {
        // Mendapatkan informasi wali murid berdasarkan ID dari database
        WaliMurid waliMurid = waliMuridDAO.getWaliMuridById(waliMuridId);

        if (waliMurid != null) {
            // Membuat daftar penerima email dari informasi wali murid
            List<String> recipients = new ArrayList<>();
            recipients.add(waliMurid.getEmail());

            // Membuat objek Email dengan parameter yang diberikan
            Email email = new Email(subject, body, recipients, attachmentPath);

            // Mengirim email menggunakan EmailUtil
            EmailUtil.sendEmail(email);
        } else {
            System.out.println("Wali Murid dengan ID " + waliMuridId + " tidak ditemukan.");
        }
    }
}
