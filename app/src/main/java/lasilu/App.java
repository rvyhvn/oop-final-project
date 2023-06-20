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

            SiswaController siswaController = new SiswaController(connection);
            int idSiswa = 11;
            String nama = "Zaky Dio";
            String email = "zakydio@example.com";
            String phone = "1234567890";
            int idKelas = 1;
            int idWali = 1;
            int idNilai = 1;

            // Menjalankan fungsi updateSiswa
            siswaController.updateSiswa(idSiswa, nama, email, phone, idWali, idKelas, idNilai);
      
            // List<Siswa> siswaList = siswaController.getAllSiswa();
            // System.out.println("Daftar Siswa setelah pembaruan:");
            // for (Siswa siswa : siswaList) {
            //     System.out.println("ID: " + siswa.getIdSiswa());
            //     System.out.println("Nama: " + siswa.getNama());
            //     System.out.println("Email: " + siswa.getEmail());
            //     System.out.println("Phone: " + siswa.getPhone());
            //     System.out.println("Kelas ID: " + siswa.getKelas().getIdKelas());
            //     System.out.println("Wali Murid ID: " + siswa.getWaliMurid().getIdWali());
            //     System.out.println();
            // }

            WaliMuridController waliMuridController = new WaliMuridController(connection);

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

            List<Siswa> siswaByKelasList = siswaController.getSiswaByKelasId(2);
            System.out.println("Data siswa berdasar ID Kelas");
            for (Siswa siswa : siswaByKelasList) {
              System.out.println("ID: " + siswa.getIdSiswa());
              System.out.println(siswa.getNama());
              System.out.println(siswa.getWaliMurid().getIdWali());
              System.out.println("" + siswa.getEmail());
              System.out.println("" + siswa.getPhone());
              System.out.println(siswa.getKelas().getIsIpa());
              System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Menutup koneksi database
        }
    }
}

