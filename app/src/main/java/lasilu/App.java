package lasilu;

import lasilu.controller.*;
import lasilu.util.*;
import lasilu.model.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import lasilu.controller.LoginController;
import lasilu.controller.DashboardController;
import lasilu.util.DatabaseUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * This class loginForm
 */

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void showSendMessageBox(){
        try {
            FXMLLoader msgLoader = new FXMLLoader(App.class.getResource("/lasilu/view/SendMessageBox.fxml"));
            Parent msgRoot = msgLoader.load();
            // set Scene for the message
            Stage stage = new Stage();
            stage.setTitle("Send Message");
    
            stage.setScene(new Scene(msgRoot));
            stage.resizableProperty().setValue(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void dashboard(){
        Connection connection = null;
            try {
                // Membuat koneksi ke database menggunakan DatabaseUtil
                connection = DatabaseUtil.getConnection();

                // Load Dashboard.fxml
                // Load file FXML untuk Dashboard
                FXMLLoader dLoader = new FXMLLoader(App.class.getResource("/lasilu/view/Dashboard.fxml"));
                Parent dRoot = dLoader.load();
                // Set scene untuk login view
                DashboardController dashboardController = dLoader.getController();
                dashboardController.setApp(this);
                Stage dStage = new Stage();
                dStage.setScene(new Scene(dRoot));
                dStage.resizableProperty().setValue(false);
                dStage.show();
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
                DatabaseUtil.closeConnection(connection);
            }
        }
    


    @Override
    public void start(Stage primaryStage) throws Exception {
        Connection connection = null;
        try {
            // Membuat koneksi ke database menggunakan DatabaseUtil
            connection = DatabaseUtil.getConnection();

            // Load LoginForm.fxml
            // Load file FXML untuk login Form
            FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/LoginForm.fxml"));
            Parent loginRoot = loginLoader.load();
            
            // Set scene untuk login view
            primaryStage.setScene(new Scene(loginRoot));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
            DatabaseUtil.closeConnection(connection);
        }
    }
}
