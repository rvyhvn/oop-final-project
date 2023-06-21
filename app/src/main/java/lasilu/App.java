package lasilu;

import lasilu.controller.*;
import lasilu.dao.WaliMuridDAO;
import lasilu.dao.*;
import lasilu.util.*;
import lasilu.model.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // METHOD menampilkan sendMessageBox

    public void showSendMessageBox() {
        // main Debug showSendMessageBox()
        // }
        // public void start(Stage primaryStage) throws Exception {
        //
        try {
            FXMLLoader msgLoader = new FXMLLoader(App.class.getResource("/lasilu/view/EmailView.fxml"));
            Parent msgRoot = msgLoader.load();
            // set Scene for the message
            Stage stage = new Stage();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/lasilu/assets/LasiluIcon.png")));
            stage.resizableProperty().setValue(false);
            stage.setScene(new Scene(msgRoot));
            stage.setTitle("Send Message");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METHOD menampilkan dashboard
    public void dashboard() {
        try {
            // Membuat koneksi ke database menggunakan DatabaseUtil
            connection = DatabaseUtil.getConnection();

            FXMLLoader dLoader = new FXMLLoader(App.class.getResource("/lasilu/view/Dashboard.fxml"));
            Parent dRoot = dLoader.load();

            DashboardController dashboardController = dLoader.getController();
            dashboardController.setApp(this);
            AnchorPane logoPane = dashboardController.getLogoPane();
            AnchorPane mainPane = dashboardController.getMainPane();
            logoPane.prefHeightProperty().bind(mainPane.heightProperty());
            // set Scene untuk Dashboard
            Stage dStage = new Stage();
            dStage.getIcons().add(new Image(getClass().getResourceAsStream("/lasilu/assets/LasiluIcon.png")));
            dStage.resizableProperty().setValue(false);
            dStage.setScene(new Scene(dRoot));
            dStage.setTitle("Dashboard");
            dStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
            DatabaseUtil.closeConnection(connection);
        }
    }

    // Main
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Function Debug
        // dashboard();
        try {
            // Membuat koneksi ke database menggunakan DatabaseUtil
            connection = DatabaseUtil.getConnection();

            FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/LoginForm.fxml"));
            Parent loginRoot = loginLoader.load();

            // Set scene untuk loginForm
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/lasilu/assets/LasiluIcon.png")));
            primaryStage.resizableProperty().setValue(false);
            primaryStage.setScene(new Scene(loginRoot));
            primaryStage.setTitle("Login Form");
            primaryStage.show();
            // Setelah login berhasil

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
            DatabaseUtil.closeConnection(connection);
        }
    }

    Connection connection = null;
}

// public class App {

// public static void main(String[] args) {

// // Mengatur pengirim email
// // Membuat objek Email
// Email email = new Email();
// email.setEMAIL_SENDER("sender@example.com"); // Mengatur alamat email
// pengirim
// email.setSubject("Subjek Email"); // Mengatur subjek email
// email.setBody("Isi email"); // Mengatur isi email
// List<String> recipients = new ArrayList<>();
// recipients.add("11221062@student.itk.ac.id"); // Menambahkan penerima email
// recipients.add("11221050@student.itk.ac.id");
// email.setRecipients(recipients);

// // Jika Anda ingin melampirkan file, atur path ke file tersebut
// // email.setAttachmentPath("path/to/attachment/file.pdf");

// // Mengirim email menggunakan EmailUtil
// EmailUtil.sendEmail(email);

// // Mendapatkan koneksi ke database
// // WaliMurid waliMurid1 = new WaliMurid();
// // waliMurid1.setNama("Sumanto");

// // System.out.println(waliMurid1.getNama());
// // Connection connection = null;
// // try {
// // connection = DatabaseUtil.getConnection();
// // EmailController emailController = new EmailController();

// // int idKelas = 11;
// // String emailSender = "koncipandawa@gmail.com";
// // String subject = "Hai, ini email dari Gradle!";
// // String body = "cok";
// // String attachmentPath = "~/Downloads/output.csv";
// // emailController.sendEmailToWaliMurid(idKelas, emailSender, subject, body,
// // attachmentPath);

// // WaliMuridController waliMuridController = new
// // WaliMuridController(connection);

// // List<String> waliMuridEmails =
// // waliMuridController.getEmailsWaliMurid(idKelas);
// // System.out.println(waliMuridEmails);

// // List<WaliMurid> waliMurids = waliMuridController.getAllWaliMurid();
// // System.out.println("Data wali murid: ");
// // for (WaliMurid wali : waliMurids) {
// // System.out.println("ID : " + wali.getIdWali());
// // System.out.println("Nama : " + wali.getNama());
// // System.out.println("Email : " + wali.getEmail());
// // System.out.println("Phone : " + wali.getPhone());
// // System.out.println("ID Anak : " + wali.getAnak().getIdSiswa());
// // System.out.println();
// // }

// // WaliMurid waliMuridBySiswa = waliMuridController.getWaliMuridBySiswaId(1);
// // System.out.println(waliMuridBySiswa.getNama());
// // System.out.println();

// // SiswaController siswaController = new SiswaController(connection);

// // List<Siswa> siswas = siswaController.getSiswaByKelasId(idKelas);
// // for (Siswa siswa : siswas) {
// // System.out.println("ID : " + siswa.getIdSiswa());
// // System.out.println("Nama : " + siswa.getNama());
// // System.out.println("Nama Wali Murid : " + siswa.getWaliMurid().getNama());
// // System.out.println("Nilai mean : " + siswa.getNilaiMean().getNilaiMean());
// // System.out.println();
// // }

// // } catch (SQLException e) {
// // e.printStackTrace();
// // Menutup koneksi database
// }
// }
