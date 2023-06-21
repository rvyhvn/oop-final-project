package lasilu;

import lasilu.controller.*;
import lasilu.dao.*;
import lasilu.util.*;
import lasilu.model.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import lasilu.controller.LoginController;
import lasilu.controller.MainViewController;
import lasilu.util.DatabaseUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// /*
//  * This class Email
//  */
// public class App extends Application {

//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) throws Exception {
//         Connection connection = null;
//         try {
//             // Membuat koneksi ke database menggunakan DatabaseUtil
//             connection = DatabaseUtil.getConnection();

//             // Load sendMassageBox.fxml
//             // Load file FXML untuk sendMassageBox
//             FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/sendMassageBox.fxml"));
//             Parent loginRoot = loginLoader.load();
//             // Set scene untuk login view
//             primaryStage.setScene(new Scene(loginRoot));
//             primaryStage.resizableProperty().setValue(false);
//             primaryStage.show();
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
//             DatabaseUtil.closeConnection(connection);
//         }
//     }
// }

/*
 * This class Dashboard
 */
// public class App extends Application {

//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) throws Exception {
//         Connection connection = null;
//         try {
//             // Membuat koneksi ke database menggunakan DatabaseUtil
//             connection = DatabaseUtil.getConnection();

//             // Load Dashboard.fxml
//             // Load file FXML untuk Dashboard
//             FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/Dashboard.fxml"));
//             Parent loginRoot = loginLoader.load();
//             // Set scene untuk login view
//             primaryStage.setScene(new Scene(loginRoot));
//             primaryStage.resizableProperty().setValue(false);
//             primaryStage.show();
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
//             DatabaseUtil.closeConnection(connection);
//         }
//     }
// }

/*
 * This class loginForm
 */

/*
 * This class Email
 */
// public class App extends Application {

//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) throws Exception {
//         Connection connection = null;
//         try {
//             // Membuat koneksi ke database menggunakan DatabaseUtil
//             connection = DatabaseUtil.getConnection();



//             // Load Dashboard.fxml
//             // Load file FXML untuk Dashboard
//             FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/Dashboard.fxml"));
//             Parent loginRoot = loginLoader.load();
//             // Set scene untuk login view
//             primaryStage.setScene(new Scene(loginRoot));
//             primaryStage.resizableProperty().setValue(false);
//             primaryStage.show();
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
//             DatabaseUtil.closeConnection(connection);
//         }
//     }
// }
/*
 * This class loginForm
 */


// <<<<<<< HEAD
public class App {

    public static void main(String[] args) {
        // Mendapatkan koneksi ke database
        WaliMurid waliMurid1 = new WaliMurid();
        waliMurid1.setNama("Sumanto");
        System.out.println(waliMurid1.getNama());
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
            EmailController emailController = new EmailController();
            
            int idKelas = 11;
            String subject = "Hai, ini email dari Gradle!";
            String body = "cok";
            String attachmentPath = "~/Downloads/output.csv";
            emailController.sendEmailToWaliMurid(idKelas, attachmentPath, subject, body, attachmentPath);

            WaliMuridController waliMuridController = new WaliMuridController(connection);

            List<String> waliMuridEmails = waliMuridController.getEmailsWaliMurid(idKelas);
            System.out.println(waliMuridEmails);

            List<WaliMurid> waliMurids = waliMuridController.getAllWaliMurid();
            System.out.println("Data wali murid: ");
            for (WaliMurid wali : waliMurids) {
              System.out.println("ID : " + wali.getIdWali());
              System.out.println("Nama : " + wali.getNama());
              System.out.println("Email : " + wali.getEmail());
              System.out.println("Phone : " + wali.getPhone());
              System.out.println("ID Anak : " + wali.getAnak().getIdSiswa());
              System.out.println();
            }

            WaliMurid waliMuridBySiswa = waliMuridController.getWaliMuridBySiswaId(1);
            System.out.println(waliMuridBySiswa.getNama());
            System.out.println();

            } catch (SQLException e) {
            e.printStackTrace();
            // Menutup koneksi database
        }
    }
}

