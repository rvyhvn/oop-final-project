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

            // Load Dashboard.fxml
            // Load file FXML untuk Dashboard
            FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/Dashboard.fxml"));
            Parent loginRoot = loginLoader.load();
            // Set scene untuk login view
            primaryStage.setScene(new Scene(loginRoot));
            primaryStage.resizableProperty().setValue(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
            DatabaseUtil.closeConnection(connection);
        }
    }
}
/*
 * This class loginForm
 */


// <<<<<<< HEAD
// public class App {

//     public static void main(String[] args) {
//         // Mendapatkan koneksi ke database
//         Connection connection = null;
//         try {
//             connection = DatabaseUtil.getConnection();

//             SiswaController siswaController = new SiswaController(connection);
//             int idSiswa = 11;
//             String nama = "Zaky Dio";
//             String email = "zakydio@example.com";
//             String phone = "1234567890";
//             int idKelas = 1;
//             int idWali = 1;
//             int idNilai = 1;

//             // Menjalankan fungsi updateSiswa
//             siswaController.updateSiswa(idSiswa, nama, email, phone, idWali, idKelas, idNilai);

//             List<Siswa> siswaList = siswaController.getAllSiswa();
//             System.out.println("Daftar Siswa setelah pembaruan:");
//             for (Siswa siswa : siswaList) {
//                 System.out.println("ID: " + siswa.getIdSiswa());
//                 System.out.println("Nama: " + siswa.getNama());
//                 System.out.println("Email: " + siswa.getEmail());
//                 System.out.println("Phone: " + siswa.getPhone());
//                 System.out.println("Kelas ID: " + siswa.getKelas().getIdKelas());
//                 System.out.println("Wali Murid ID: " + siswa.getWaliMurid().getIdWali());
//                 System.out.println();
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//             // Menutup koneksi database
//         }
//     }
// }

// =======
//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) throws Exception {
//         Connection connection = null;
//         try {
//             // Membuat koneksi ke database menggunakan DatabaseUtil
//             connection = DatabaseUtil.getConnection();

//             // Load LoginForm.fxml
//             // Load file FXML untuk login Form
//             FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/LoginForm1.fxml"));
//             Parent loginRoot = loginLoader.load();
//             LoginController loginController = loginLoader.getController();
//             loginController.setConnection(connection);
//             loginController.setOnLoginSuccess(() -> {
//                 try {
//                     // Load file FXML untuk main view
//                     FXMLLoader mainLoader = new FXMLLoader(App.class.getResource("../lasilu/view/MainView.fxml"));
//                     Parent mainRoot = mainLoader.load();
//                     MainViewController mainController = mainLoader.getController();
//                     mainController.initData(); // Mengambil data siswa dan melakukan inisialisasi tampilan

//                     // Set scene untuk main view
//                     primaryStage.setScene(new Scene(mainRoot));
//                     primaryStage.show();
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//             });

//             // Set scene untuk login view
//             primaryStage.setScene(new Scene(loginRoot));
//             primaryStage.show();
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
//             DatabaseUtil.closeConnection(connection);
//         }
//     }
// }
