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
import lasilu.controller.DashboardController2;
import lasilu.util.DatabaseUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * This Dashboard class
 */
// public class App extends Application {

//     public void showSendMessageBox(){
        
//         try {
//             FXMLLoader msgLoader = new FXMLLoader(App.class.getResource("/lasilu/view/SendMessageBox.fxml"));
//             Parent msgRoot = msgLoader.load();
//             // set Scene for the message
//             Stage stage = new Stage();
//             stage.setTitle("Send Message");
            
//             stage.setScene(new Scene(msgRoot));
//             stage.resizableProperty().setValue(false);
//             stage.show();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) throws Exception {
//         Connection connection = null;
//         try {
//             // Membuat koneksi ke database menggunakan DatabaseUtil
//             connection = DatabaseUtil.getConnection();

//             // Load Dashboard.fxml
//             // Load file FXML untuk Dashboard
//             FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/Dashboard.fxml"));
//             Parent loginRoot = loginLoader.load();
//             // Set scene untuk login view
//             DashboardController2 dashboardController = loginLoader.getController();
//             dashboardController.setApp(this);
//             primaryStage.setScene(new Scene(loginRoot));
//             primaryStage.resizableProperty().setValue(false);
//             primaryStage.show();
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             // Menutup koneksi dan sumber daya terkait menggunakan DatabaseUtil
//             DatabaseUtil.closeConnection(connection);
//         }
//     }
// }

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Connection connection = null;
        try {
            // Membuat koneksi ke database menggunakan DatabaseUtil
            connection = DatabaseUtil.getConnection();

            // Load LoginForm.fxml
            // Load file FXML untuk login Form
            FXMLLoader loginLoader = new FXMLLoader(App.class.getResource("/lasilu/view/LoginForm1.fxml"));
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
