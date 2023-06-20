package lasilu.controller;

import lasilu.dao.LoginDAO;
import lasilu.model.Guru;
import lasilu.App;
import lasilu.util.DatabaseUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    private Connection connection;
    private Runnable onLoginSuccess;

    public void login() throws IOException {
        String email = emailField.getText();
        String password = passwordField.getText();

        try (Connection connection = DatabaseUtil.getConnection()) {
            LoginDAO loginDAO = new LoginDAO(connection);
            Guru guru = loginDAO.login(email, password);
            if (guru != null) {
                App app = new App();
                app.dashboard();

            } else {
                showErrorMessage("Login gagal", "Email atau password salah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorMessage("Error", "Terjadi kesalahan saat mengakses database");
        }

    }

    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setOnLoginSuccess(Runnable onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;
    }
}
