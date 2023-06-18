package com.project.controller;

import com.project.dao.LoginDAO;
import com.project.model.Guru;
import com.project.util.DatabaseUtil;
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
                // Login berhasil, lakukan aksi sesuai kebutuhan
                // Misalnya, pindah ke halaman utama setelah login sukses
                // MainViewController mainViewController = new MainViewController(guru);
                // mainViewController.showMainView();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/MainView.fxml"));
                Parent root = loader.load();
                MainViewController mainViewController = loader.getController();
                mainViewController.setGuru(guru);

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                // Tutup jendela login saat ini
                Stage currentStage = (Stage) emailField.getScene().getWindow();
                currentStage.close();
            } else {
                showErrorMessage("Login gagal", "Email atau password salah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorMessage("Error", "Terjadi kesalahan saat mengakses database");
        } catch (IOException e) {
            e.printStackTrace();
            showErrorMessage("Error", "Terjadi kesalahan saat memuat GUI utama");
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
