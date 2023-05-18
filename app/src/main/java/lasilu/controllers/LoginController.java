package lasilu.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

        // Lakukan proses login sesuai kebutuhan Anda
        // Contoh sederhana untuk memeriksa username dan password:
        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Login gagal!");
        }
    }
}
