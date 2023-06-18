package com.project.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    private static final String CONFIG_FILE_PATH = System.getProperty("user.home") + "/.config/final-project-cli/config.properties";

    public static Connection getConnection() throws SQLException {
        Properties config = loadConfigProperties();
        String url = config.getProperty("db.url");
        String username = config.getProperty("db.username");
        String password = config.getProperty("db.password");
        return DriverManager.getConnection(url, username, password);
    }

    private static Properties loadConfigProperties() {
        Properties config = new Properties();
        try (FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH)) {
            config.load(inputStream);
        } catch (IOException e) {
            System.out.println("Failed to load config.properties file: " + e.getMessage());
        }
        return config;
    }

    public static void closeConnection(Connection connection) {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          System.out.println("Failed to close connection!");
        }
      }
    }
}
