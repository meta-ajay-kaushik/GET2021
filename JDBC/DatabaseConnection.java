package JDBC;
import java.sql.*;
public class DatabaseConnection {
    public static Connection getConnection() {
        System.out.println("Connecting...");
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/storeFront";
            String userName = "root";
            String password = "mysql786";
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }
}