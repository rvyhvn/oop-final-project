package lasilu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lasilu.dao.WaliMuridDAO;
import lasilu.model.Email;
import lasilu.model.WaliMurid;
import lasilu.util.DatabaseUtil;
import lasilu.util.EmailUtil;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailController {
    private WaliMuridDAO waliMuridDAO;
    private EmailUtil emailUtil;

    @FXML
    private TextField toField;
    @FXML
    private TextField fromField;
    @FXML
    private TextField subjectField;
    @FXML
    private TextArea sendMessageBox;
    @FXML
    private Button attachmentButton;
    @FXML
    private Button clearButton;


    public EmailController() throws SQLException {
        // Membuat koneksi ke database
        Connection connection = DatabaseUtil.getConnection();
        // Membuat instance WaliMuridDAO
        waliMuridDAO = new WaliMuridDAO(connection);
    }

    @FXML
    private void attachmentButtonClicked(ActionEvent event) {
        // Membuka file explorer
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        // Memeriksa apakah file dipilih atau tidak
        if (selectedFile != null) {
            // Menyimpan nama file ke dalam sendMessageBox
            sendMessageBox.setText(selectedFile.getName());
        } else {
            // Menampilkan pesan jika tidak ada file yang dipilih
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No File Selected");
            alert.setHeaderText(null);
            alert.setContentText("No file selected. Please choose a CSV file.");
            alert.showAndWait();
        }
    }

    @FXML
    private void sendButtonClicked(ActionEvent event) {
        String recipient = "waliMurid@gmail.com";
        String subject = "Laporan Hasil Nilai Ujian";
        String body = sendMessageBox.getText();
        String attachmentPath = sendMessageBox.getText(); // Menggunakan isi dari sendMessageBox sebagai path file

        // Mengirim email menggunakan EmailUtil
        sendEmailToWaliMurid(recipient, subject, body, attachmentPath);

        // Menampilkan pesan berhasil
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Email Sent");
        alert.setHeaderText(null);
        alert.setContentText("Email has been sent to waliMurid@gmail.com");
        alert.showAndWait();

        // Mengosongkan sendMessageBox
        sendMessageBox.clear();
    }

    @FXML
    private void clearButtonClicked(ActionEvent event) {
        toField.clear();
        fromField.clear();
        subjectField.clear();
        sendMessageBox.clear();
    }

    private void sendEmailToWaliMurid(String recipient, String subject, String body, String attachmentPath) {
        try {
            // Mendapatkan daftar email wali murid berdasarkan kelasId
            List<String> recipients = getEmailsWaliMurid();

            // Membuat instance Email
            Email email = new Email(recipient, subject, body, recipients, attachmentPath);

            // Proses pengiriman email
            sendEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<String> getEmailsWaliMurid() throws SQLException {
        // Mendapatkan daftar wali murid berdasarkan kelasId
        List<WaliMurid> waliMuridList = new ArrayList<>();
        // Ganti dengan metode yang sesuai untuk mendapatkan daftar wali murid dari database
        waliMuridList = waliMuridDAO.getWaliMuridBySiswaId(0);

        // Menyimpan email wali murid ke dalam List
        List<String> recipients = new ArrayList<>();
        for (WaliMurid waliMurid : waliMuridList) {
            recipients.add(waliMurid.getEmail());
        }

        return recipients;
    }

    private void sendEmail(Email email) {
        // Menggunakan EmailUtil untuk mengirim email
        emailUtil.sendEmail(email);
    }
}
