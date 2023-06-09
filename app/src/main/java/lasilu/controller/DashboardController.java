package lasilu.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import lasilu.App;
import lasilu.dao.KelasDAO;
import lasilu.dao.SiswaDAO;
import lasilu.model.Kelas;
import lasilu.model.Siswa;
import lasilu.util.DatabaseUtil;
import javafx.beans.property.SimpleObjectProperty;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private AnchorPane logoPane;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private GridPane gridPane;

    @FXML
    private VBox logoContainer;

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

    //
    public AnchorPane getLogoPane() {
        return logoPane;
    }

    public AnchorPane getMainPane() {
        return mainPane;
    }

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private void buatLaporan() {
        if (app != null) {
            app.showSendMessageBox();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
        Connection connection;
        try {
            connection = DatabaseUtil.getConnection();
            siswaDAO = new SiswaDAO(connection);
            KelasDAO = new KelasDAO(connection);
        } catch (SQLException e) {
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

        // Menghubungkan atribut PropertyValueFactory dengan properti pada model Siswa
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idSiswa"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        waliMuridColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getWaliMurid().getNama()));
        nilaiRataRataColumn.setCellValueFactory(cellData -> {
            Double nilaiRataRata = cellData.getValue().getNilaiMean().getNilaiMean();
            return new SimpleObjectProperty<>(nilaiRataRata);
        });

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
    }

}
