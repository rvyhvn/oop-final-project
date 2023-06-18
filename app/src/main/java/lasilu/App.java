package lasilu;

import lasilu.controller.*;
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

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Connection connection = null;
        try {
            // Membuat koneksi ke database menggunakan DatabaseUtil
            connection = DatabaseUtil.getConnection();

            // Load LoginView.fxml
            // Load file FXML untuk login view
            FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/LoginView.fxml"));
            Parent loginRoot = loginLoader.load();
            LoginController loginController = loginLoader.getController();
            loginController.setConnection(connection);
            loginController.setOnLoginSuccess(() -> {
                try {
                    // Load file FXML untuk main view
                    FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/lasilu/MainView.fxml"));
                    Parent mainRoot = mainLoader.load();
                    MainViewController mainController = mainLoader.getController();
                    mainController.initData(); // Mengambil data siswa dan melakukan inisialisasi tampilan

                    // Set scene untuk main view
                    primaryStage.setScene(new Scene(mainRoot));
                    primaryStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // Set scene untuk login view
            primaryStage.setScene(new Scene(loginRoot));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
            DatabaseUtil.closeConnection(connection);
        }
    }
}
// public class App {
// public static void main(String[] args) {
// Connection connection = null;
// try {
// // Membuat koneksi ke database menggunakan DatabaseUtil
// connection = DatabaseUtil.getConnection();

// // Membuat objek SiswaController
// SiswaController siswaController = new SiswaController(connection);

// // Mengambil semua siswa dari database
// List<Siswa> siswaList = siswaController.getAllSiswa();

// // Menampilkan informasi siswa
// for (Siswa siswa : siswaList) {
// System.out.println("ID Siswa: " + siswa.getIdSiswa());
// System.out.println("Nama: " + siswa.getNama());
// System.out.println("Email: " + siswa.getEmail());
// System.out.println("Phone: " + siswa.getPhone());
// System.out.println("ID Kelas: " + siswa.getKelas().getIdKelas());
// System.out.println("Tingkat Kelas: " + siswa.getKelas().getTingkat());
// System.out.println("Urutan Kelas: " + siswa.getKelas().getUrutan());
// System.out.println("Is IPA: " + siswa.getKelas().getIsIpa());
// System.out.println("ID Wali Murid: " + siswa.getWaliMurid().getIdWali());
// System.out.println("Nama Wali Murid: " + siswa.getWaliMurid().getNama());
// System.out.println("Email Wali Murid: " + siswa.getWaliMurid().getEmail());
// System.out.println("Phone Wali Murid: " + siswa.getWaliMurid().getPhone());
// System.out.println("----------------------------------");
// }
// } catch (SQLException e) {
// e.printStackTrace();
// } finally {
// // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
// DatabaseUtil.closeConnection(connection);
// }
// }
// }
