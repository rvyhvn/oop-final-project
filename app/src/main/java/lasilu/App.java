package lasilu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/lasilu/LoginForm.fxml"));
      VBox root = loader.load();

      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Login FOrm");
      primaryStage.show();
    }
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println(new App().getGreeting());
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("/etc/postgresql/.config/oop-final-project/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String DB_URL = properties.getProperty("db.url");
        String USER = properties.getProperty("db.username");
        String PASS = properties.getProperty("db.password");

        // Kode untuk memproses login
        String username = "zakypeler"; // Ganti dengan username yang ingin Anda cek
        String password = "pelerzaky"; // Ganti dengan password yang ingin Anda cek

        Connection connection = null;
        try {
            // Membuat koneksi ke database
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Mengeksekusi query untuk memeriksa login
            String query = "SELECT * FROM akun WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Login berhasil
                System.out.println("Login berhasil");
            } else {
                // Login gagal
                System.out.println("Login gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        launch(args);
        }
    }
}
