package lasilu.controllers;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.DriverManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

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

        try {
          Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
          String query = "SELECT * FROM akun WHERE username = ? AND password = ?";
          PreparedStatement statement = connection.prepareStatement(query);
          statement.setString(1, username);
          statement.setString(2, password);

          ResultSet resultSet = statement.executeQuery();
          
          if (resultSet.next()) {
            System.out.println("Login berhasil!");
          } else {
            System.out.println("Login gagal!");
          }
          
          connection.close();

        } catch (SQLException e) {
          e.printStackTrace();
        }
    }

}
