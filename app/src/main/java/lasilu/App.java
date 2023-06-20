package lasilu;

import lasilu.controller.*;
import lasilu.util.*;
import lasilu.model.*;

import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import lasilu.controller.DashboardController;
import lasilu.util.DatabaseUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // METHOD menampilkan sendMessageBox
    
    public void showSendMessageBox(){
    }
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader msgLoader = new FXMLLoader(App.class.getResource("/lasilu/view/EmailView.fxml"));
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
    // METHOD menampilkan dashboard
    public void dashboard(){
            try {
                // Membuat koneksi ke database menggunakan DatabaseUtil
                connection = DatabaseUtil.getConnection();
                
                FXMLLoader dLoader = new FXMLLoader(App.class.getResource("/lasilu/view/Dashboard.fxml"));
                Parent dRoot = dLoader.load();
                
                DashboardController dashboardController = dLoader.getController();
                dashboardController.setApp(this);
                // set Scene untuk Dashboard
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
    
    // Main 
    // @Override
    // public void start(Stage primaryStage) throws Exception {
    //     try {
    //         // Membuat koneksi ke database menggunakan DatabaseUtil
    //         connection = DatabaseUtil.getConnection();

    //         FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/LoginForm.fxml"));
    //         Parent loginRoot = loginLoader.load();
            
    //         // Set scene untuk loginForm
    //         primaryStage.setScene(new Scene(loginRoot));
    //         primaryStage.show();

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     } finally {
    //         // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
    //         DatabaseUtil.closeConnection(connection);
    //     }
    // }

    Connection connection = null;
}
