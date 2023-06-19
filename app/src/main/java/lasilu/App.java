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


public class App {

    public static void main(String[] args) {
        // Mendapatkan koneksi ke database
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

            List<Siswa> siswaList = siswaController.getAllSiswa();
            System.out.println("Daftar Siswa setelah pembaruan:");
            for (Siswa siswa : siswaList) {
                System.out.println("ID: " + siswa.getIdSiswa());
                System.out.println("Nama: " + siswa.getNama());
                System.out.println("Email: " + siswa.getEmail());
                System.out.println("Phone: " + siswa.getPhone());
                System.out.println("Kelas ID: " + siswa.getKelas().getIdKelas());
                System.out.println("Wali Murid ID: " + siswa.getWaliMurid().getIdWali());
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Menutup koneksi database
        }
    }
}

