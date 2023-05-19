/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lasilu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App{
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
    }
}

  
    
    // public static void main(String[] args) throws SQLException, ClassNotFoundException {
    //     System.out.println(new App().getGreeting());
    //     Properties properties = new Properties();
    //     try (FileInputStream fis = new FileInputStream("/home/hanshi/.config/oop-final-project/config.properties")) {
    //       properties.load(fis);
    //     } catch (IOException e) {
    //       e.printStackTrace();
    //       return;
    //     }
    //     String DB_URL = properties.getProperty("db.url");
    //     String USER = properties.getProperty("db.username");
    //     String PASS = properties.getProperty("db.password");

    //     Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    // }
    // protected String getTimeNow() {
    //   DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    //     return LocalDateTime.now().format(myFormat);
    // }

