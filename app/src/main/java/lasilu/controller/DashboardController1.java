package lasilu.controller;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Callback;
import lasilu.dao.SiswaDAO;
import lasilu.model.Siswa;
import lasilu.util.DatabaseUtil;
import javafx.geometry.Pos;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.sun.javafx.logging.PlatformLogger.Level;

public class DashboardController1 implements Initializable {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private GridPane gridPane;

    @FXML
    private TableView<Siswa> tableView;

    @FXML
    private TableColumn<Siswa, Integer> noColumn;

    @FXML
    private TableColumn<Siswa, String> namaColumn;

    @FXML
    private TableColumn<Siswa, String> waliMuridColumn;

    @FXML
    private TableColumn<Siswa, Double> nilaiRataRataColumn;

    @FXML
    private HBox comboBoxContainer;

    @FXML
    private ComboBox<String> kelasComboBox;

    @FXML
    private AnchorPane logoPane;

    @FXML
    private VBox logoContainer;

    @FXML
    private ImageView logoImageView;

    @FXML
    private Button buatLaporanButton;

    private SiswaDAO siswaDAO;

    Siswa siswa = null;
    private SiswaController siswaController;
    String query = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    ResultSet resultSet = null;

    ObservableList<Siswa> SiswaList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection connection = DatabaseUtil.getConnection(); // Menghubungkan ke database
            siswaController = new SiswaController(connection);
            setupTableColumns();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle error connecting to the database
        }
        // loadSiswaData();
        setupTableColumns();
        setupComboBox();

    }

    private void refreshTableColumns() {
        SiswaList.clear();
        try {
            query = "SELECT * FROM 'siswa'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SiswaList.add(new Siswa(
                        resultSet.getInt("id"),
                        resultSet.getString("nama"), null, query, query, null, null));
                tableView.setItems(SiswaList);
            }
        } catch (SQLException exception) {
            Logger.getLogger(DashboardController1.class.getName()).log(null);
        }
    }

    // private void loadSiswaData() {
    // try{
    // // Ambil data siswa dari objek siswaDAO
    // List<Siswa> daftarSiswa = siswaController.getAllSiswa();

    // // Buat daftar item data
    // List<Siswa> daftarData = new ArrayList<>();
    // int no = 1;

    // for (Siswa siswa : daftarSiswa) {
    // // Ambil nama siswa
    // String namaSiswa = siswa.getNama();

    // // Buat item data baru dengan menggunakan nama siswa
    // DataItem dataItem = new DataItem(no, namaSiswa, "ada", 0.0);
    // daftarData.add(dataItem);

    // no++;
    // }

    // // Set data ke dalam tabel
    // tableView.getItems().setAll(daftarData);
    // }catch(SQLException ex){
    // Logger.getLogger(DashboardController1.class.getName()).log(null);
    // }

    // }

    private void setupTableColumns() {
        refreshTableColumns();
        noColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        // Set table data
        // Buat ObservableList kosong untuk menginisialisasi tableView

    }

    private void setupComboBox() {
        // Setup combo box items and event handler
        kelasComboBox.setItems(null); // Ganti dengan data yang sesuai
        kelasComboBox.setOnAction(event -> {
            // Perform action when combo box selection changes
        });
    }

    @FXML
    private void buatLaporan() {
        // Implementasi logika untuk membuat laporan di sini
    }

    // Data model class

}
