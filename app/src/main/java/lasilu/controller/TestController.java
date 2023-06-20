// package lasilu.controller;

// import javafx.beans.property.DoubleProperty;
// import javafx.beans.property.IntegerProperty;
// import javafx.beans.property.StringProperty;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.beans.property.SimpleDoubleProperty;
// import javafx.beans.property.SimpleIntegerProperty;
// import javafx.beans.property.SimpleStringProperty;
// import javafx.fxml.FXML;
// import javafx.fxml.Initializable;
// import javafx.scene.control.Button;
// import javafx.scene.control.ComboBox;
// import javafx.scene.control.TableCell;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableView;
// import javafx.scene.image.Image;
// import javafx.scene.image.ImageView;
// import javafx.scene.layout.AnchorPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.Pane;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.scene.text.Font;
// import javafx.util.Callback;
// import lasilu.controller.DashboardController.DataItem;
// import lasilu.dao.SiswaDAO;
// import lasilu.model.Siswa;
// import lasilu.util.DatabaseUtil;
// import javafx.geometry.Pos;

// import java.net.URL;
// import java.sql.Connection;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.ResourceBundle;

// public class TestController implements Initializable {
//     @FXML
//     private AnchorPane rootPane;

//     @FXML
//     private GridPane gridPane;

//     @FXML
//     private TableView<DataItem> tableView;

//     @FXML
//     private TableColumn<DataItem, Integer> noColumn;

//     @FXML
//     private TableColumn<DataItem, String> namaColumn;

//     @FXML
//     private TableColumn<DataItem, String> waliMuridColumn;

//     @FXML
//     private TableColumn<DataItem, Double> nilaiRataRataColumn;

//     @FXML
//     private HBox comboBoxContainer;

//     @FXML
//     private ComboBox<String> kelasComboBox;

//     @FXML
//     private AnchorPane logoPane;

//     @FXML
//     private VBox logoContainer;

//     @FXML
//     private ImageView logoImageView;

//     @FXML
//     private Button buatLaporanButton;

//     private SiswaDAO siswaDAO;

//     private SiswaController siswaController;

//     @Override
//     public void initialize(URL location, ResourceBundle resources) {
//         try {
//             Connection connection = DatabaseUtil.getConnection(); // Menghubungkan ke database
//             siswaController = new SiswaController(connection);
//             setupTableColumns();
//             loadDataSiswa();
//         } catch (SQLException e) {
//             e.printStackTrace();
//             // Handle error connecting to the database
//         }
//         setupTableColumns();

//     }

//     private void loadDataSiswa() {
//         List<Siswa> siswaList = siswaController.getAllSiswa();
//         ObservableList<DataItem> dataItems = FXCollections.observableArrayList();

//         if (siswaList != null) {
//             int index = 1;
//             for (Siswa siswa : siswaList) {
//                 String nama = siswa.getNama();
//                 String email = siswa.getEmail();
//                 String phone = siswa.getPhone();
//                 int waliId = siswa.getWaliMurid().getIdWaliMurid();
//                 int kelasId = siswa.getKelas().getIdKelas();
//                 int nilaiId = siswa.getNilai().getIdNilai();

//                 dataItems.add(new DataItem(index, nama, email, phone, waliId, kelasId, nilaiId));
//                 index++;
//             }
//         }

//         tableView.setItems(dataItems);
//     }

//     public void setupTableColumns() {
//         TableColumn<DataItem, String> namaColumn = new TableColumn<>("Nama");
//         namaColumn.setCellValueFactory(cellData -> cellData.getValue().namaProperty());

//         TableColumn<DataItem, String> emailColumn = new TableColumn<>("Email");
//         emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

//         TableColumn<DataItem, String> phoneColumn = new TableColumn<>("Phone");
//         phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

//         TableColumn<DataItem, Integer> waliMuridIdColumn = new TableColumn<>("Wali ID");
//         waliMuridIdColumn.setCellValueFactory(cellData -> cellData.getValue().waliMuridIdProperty().asObject());

//         TableColumn<DataItem, Integer> kelasIdColumn = new TableColumn<>("Kelas ID");
//         kelasIdColumn.setCellValueFactory(cellData -> cellData.getValue().kelasIdProperty().asObject());

//         TableColumn<DataItem, Integer> nilaiIdColumn = new TableColumn<>("Nilai ID");
//         nilaiIdColumn.setCellValueFactory(cellData -> cellData.getValue().nilaiIdProperty().asObject());

//         tableView.setItems(DataItem);
//     }

//     public class DataItem {
//         private IntegerProperty id;
//         private StringProperty nama;
//         private StringProperty email;
//         private StringProperty phone;
//         private IntegerProperty waliMuridId;
//         private IntegerProperty kelasId;
//         private IntegerProperty nilaiId;

//         public DataItem(int id, String nama, String email, String phone, int waliMuridId, int kelasId, int nilaiId) {
//             this.id = new SimpleIntegerProperty(id);
//             this.nama = new SimpleStringProperty(nama);
//             this.email = new SimpleStringProperty(email);
//             this.phone = new SimpleStringProperty(phone);
//             this.waliMuridId = new SimpleIntegerProperty(waliMuridId);
//             this.kelasId = new SimpleIntegerProperty(kelasId);
//             this.nilaiId = new SimpleIntegerProperty(nilaiId);
//         }

//         public int getId() {
//             return id.get();
//         }

//         public IntegerProperty idProperty() {
//             return id;
//         }

//         public void setId(int id) {
//             this.id.set(id);
//         }

//         public String getNama() {
//             return nama.get();
//         }

//         public StringProperty namaProperty() {
//             return nama;
//         }

//         public void setNama(String nama) {
//             this.nama.set(nama);
//         }

//         public String getEmail() {
//             return email.get();
//         }

//         public StringProperty emailProperty() {
//             return email;
//         }

//         public void setEmail(String email) {
//             this.email.set(email);
//         }

//         public String getPhone() {
//             return phone.get();
//         }

//         public StringProperty phoneProperty() {
//             return phone;
//         }

//         public void setPhone(String phone) {
//             this.phone.set(phone);
//         }

//         public int getWaliMuridId() {
//             return waliMuridId.get();
//         }

//         public IntegerProperty waliMuridIdProperty() {
//             return waliMuridId;
//         }

//         public void setWaliMuridId(int waliMuridId) {
//             this.waliMuridId.set(waliMuridId);
//         }

//         public int getKelasId() {
//             return kelasId.get();
//         }

//         public IntegerProperty kelasIdProperty() {
//             return kelasId;
//         }

//         public void setKelasId(int kelasId) {
//             this.kelasId.set(kelasId);
//         }

//         public int getNilaiId() {
//             return nilaiId.get();
//         }

//         public IntegerProperty nilaiIdProperty() {
//             return nilaiId;
//         }

//         public void setNilaiId(int nilaiId) {
//             this.nilaiId.set(nilaiId);
//         }
//     }

// }
