package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConfig {
    private static String DATABASE_URL = "jdbc:postgresql://localhost:5432/book-author_db";
    private static String DATABASE_USER_NAME = "postgres";
    private static String DATABASE_PASSWORD = "password";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
        System.out.println("Successfully Connection");
        return connection;
    }
}
