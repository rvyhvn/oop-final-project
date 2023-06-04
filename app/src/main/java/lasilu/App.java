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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/lasilu/LoginForm.fxml"));
    AnchorPane root = loader.load();

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Login Form");
    primaryStage.show();
  }

  public String getGreeting() {
    return "Hello World!";
  }

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    System.out.println(new App().getGreeting());
    launch(args);
  }
}
