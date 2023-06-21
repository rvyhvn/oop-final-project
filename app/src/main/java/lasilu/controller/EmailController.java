package lasilu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    private WaliMuridController waliMuridController;
    private EmailUtil emailUtil;

    public EmailController(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    public EmailController() throws SQLException {
        // Membuat koneksi ke database
        Connection connection = DatabaseUtil.getConnection();
        // Membuat instance WaliMuridDAO
        waliMuridController = new WaliMuridController(connection);
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
        String to = toField.getText();
        String subject = subjectField.getText();
        String body = sendMessageBox.getText();
        String attachmentPath = sendMessageBox.getText(); // Menggunakan isi dari sendMessageBox sebagai path file
        // Mengirim email menggunakan EmailUtil
        sendEmailToWaliMurid(1, to, subject, body, attachmentPath);

        showInformationAlert("Email Sent", "Email has been sent successfully!");

        // if (isEmailSent) {
        //     showInformationAlert("Email Sent", "Email has been sent successfully!");
        // } else {
        //     showInformationAlert("Email Not Sent", "Failed to send email. Please try again.");
        // }
        // Menampilkan pesan berhasil
        // Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // alert.setTitle("Email Sent");
        // alert.setHeaderText(null);
        // alert.setContentText("Email has been sent to waliMurid@gmail.com");
        // alert.showAndWait();

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

    public void sendEmailToWaliMurid(int idKelas, String EMAIL_SENDER, String subject, String body, String attachmentPath) {
        try {
            // Mendapatkan daftar email wali murid berdasarkan kelasId
            List<String> recipients = waliMuridController.getEmailsWaliMurid(idKelas);

            // Membuat instance Email
            Email email = new Email(EMAIL_SENDER, subject, body, recipients, attachmentPath);

            // Proses pengiriman email
            sendEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showInformationAlert(String title, String message) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }


    // private List<String> getEmailsWaliMurid(int idKelas) throws SQLException {
    //     // Mendapatkan daftar wali murid berdasarkan kelasId
    //     List<WaliMurid> waliMuridList = new ArrayList<>();
    //     waliMuridList = waliMuridDAO.getWaliMuridBySiswaId(idKelas);

    //     // Menyimpan email wali murid ke dalam List
    //     List<String> recipients = new ArrayList<>();
    //     for (WaliMurid waliMurid : waliMuridList) {
    //         recipients.add(waliMurid.getEmail());
    //     }

    //     return recipients;
    // }
    private void sendEmail(Email email) {
        // Menggunakan EmailUtil untuk mengirim email
        EmailUtil.sendEmail(email);
    }
}
