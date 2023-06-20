package lasilu.controller;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
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
import lasilu.model.Guru;
import lasilu.model.Siswa;
import lasilu.util.DatabaseUtil;
import javafx.geometry.Pos;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private GridPane gridPane;

    @FXML
    private TableView<DataItem> tableView;

    @FXML
    private TableColumn<DataItem, Integer> noColumn;

    @FXML
    private TableColumn<DataItem, String> namaColumn;

    @FXML
    private TableColumn<DataItem, String> waliMuridColumn;

    @FXML
    private TableColumn<DataItem, Double> nilaiRataRataColumn;

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

    private SiswaController siswaController;

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
        loadSiswaData();
        setupTableColumns();
        setupComboBox();

    }

    private void loadSiswaData() {
        // Ambil data siswa dari objek siswaDAO
        List<Siswa> daftarSiswa = siswaController.getAllSiswa();

        // Buat daftar item data
        List<DataItem> daftarData = new ArrayList<>();
        int no = 1;

        for (Siswa siswa : daftarSiswa) {
            // Ambil nama siswa
            String namaSiswa = siswa.getNama();

            // Buat item data baru dengan menggunakan nama siswa
            DataItem dataItem = new DataItem(no, namaSiswa, "asda", 0.0);
            daftarData.add(dataItem);

            no++;
        }

        // Set data ke dalam tabel
        tableView.getItems().setAll(daftarData);
    }

    private void setupTableColumns() {
        noColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        namaColumn.setCellValueFactory(cellData -> cellData.getValue().namaProperty());
        waliMuridColumn.setCellValueFactory(cellData -> cellData.getValue().waliMuridProperty());
        nilaiRataRataColumn.setCellValueFactory(cellData -> cellData.getValue().nilaiRataRataProperty().asObject());
        // Set table data
        // Buat ObservableList kosong untuk menginisialisasi tableView
        ObservableList<DataItem> dataItems = FXCollections.observableArrayList();

        // Set data ke dalam tabel
        tableView.setItems(dataItems);
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
    public static class DataItem {
        private final IntegerProperty id = new SimpleIntegerProperty();
        private final StringProperty nama = new SimpleStringProperty();
        private final StringProperty waliMurid = new SimpleStringProperty();
        private final DoubleProperty nilaiRataRata = new SimpleDoubleProperty();

        public DataItem(int id, String nama, String waliMurid, double nilaiRataRata) {
            setId(id);
            setNama(nama);
            setWaliMurid(waliMurid);
            setNilaiRataRata(nilaiRataRata);
        }

        public int getId() {
            return id.get();
        }

        public IntegerProperty idProperty() {
            return id;
        }

        public void setId(int id) {
            this.id.set(id);
        }

        public String getNama() {
            return nama.get();
        }

        public StringProperty namaProperty() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama.set(nama);
        }

        public String getWaliMurid() {
            return waliMurid.get();
        }

        public StringProperty waliMuridProperty() {
            return waliMurid;
        }

        public void setWaliMurid(String waliMurid) {
            this.waliMurid.set(waliMurid);
        }

        public double getNilaiRataRata() {
            return nilaiRataRata.get();
        }

        public DoubleProperty nilaiRataRataProperty() {
            return nilaiRataRata;
        }

        public void setNilaiRataRata(double nilaiRataRata) {
            this.nilaiRataRata.set(nilaiRataRata);
        }
    }

    public void setGuru(Guru guru) {
    }
}
