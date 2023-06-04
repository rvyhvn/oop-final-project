package lasilu.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.lang.model.util.ElementScanner14;

import java.sql.DriverManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController1 {
    @FXML 
    private TextField usernameField;

    @FXML 
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML 
    private void handleLogin(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username == ("admin") && password == ("admin123")){
            System.out.println("Login berhasil");
        }else {
        System.out.println("login gagal" );
        }
    }
}
