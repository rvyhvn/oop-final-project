package lasilu.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import lasilu.dao.SiswaDAO;
import lasilu.App;
import lasilu.dao.KelasDAO;
import lasilu.model.Siswa;
import lasilu.model.Guru;
import lasilu.model.Kelas;
import lasilu.model.Siswa;
import lasilu.util.DatabaseUtil;
import lasilu.controller.LoginController;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController2 implements Initializable {

    @FXML
    private ComboBox<Kelas> kelasComboBox;

    @FXML
    private TableView<Siswa> tableView;

    @FXML
    private TableColumn<Siswa, Integer> idColumn;

    @FXML
    private TableColumn<Siswa, String> namaColumn;

    @FXML
    private TableColumn<Siswa, String> waliMuridColumn;

    @FXML
    private TableColumn<Siswa, Double> nilaiRataRataColumn;

    @FXML
    private Button buatLaporanButton;

    private SiswaDAO siswaDAO;
    private KelasDAO KelasDAO;
    private App app;
    
    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    private void buatLaporan() {
        if (app != null){
            app.showSendMessageBox();
        }
    }
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection connection;
        try {
            connection = DatabaseUtil.getConnection();
            siswaDAO = new SiswaDAO(connection);
            KelasDAO = new KelasDAO(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        // Mengambil koneksi dari utilitas DatabaseUtil
        
        List<Kelas> kelasList;
        try {
            kelasList = KelasDAO.getAllKelas();
            kelasComboBox.getItems().setAll(kelasList);
            kelasComboBox.getSelectionModel().selectFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Mengatur kolom tabel
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idSiswa"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        waliMuridColumn.setCellValueFactory(new PropertyValueFactory<>("waliMurid"));
        nilaiRataRataColumn.setCellValueFactory(new PropertyValueFactory<>("nilaiMean"));

        // Mengambil data siswa dari database
        // List<Siswa> siswaList;
        // try {
        //     siswaList = siswaDAO.getAllSiswa();
        //     tableView.getItems().addAll(siswaList);
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }

        kelasComboBox.setOnAction(event -> {
            Kelas selectedKelas = kelasComboBox.getValue();
            if (selectedKelas != null) {
                try {
                    List<Siswa> siswaList = siswaDAO.getSiswaByKelasId(selectedKelas.getIdKelas());
                    tableView.getItems().clear();
                    tableView.getItems().addAll(siswaList);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        // Mengatur gambar logo
       
    }
    
}
