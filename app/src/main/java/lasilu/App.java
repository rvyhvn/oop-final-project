/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lasilu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(new App().getGreeting());
        String JDBC_DRIVER = "org.postgresql.Driver";
        Class.forName(JDBC_DRIVER);
        String DB_URL = "jdbc:postgresql://localhost:5432/test";
        String USER = "postgres";
        String PASS = "";

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
