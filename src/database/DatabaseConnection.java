package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection - Week 7 Addition
 * Manages PostgreSQL database connections for Clothing store System
 */
public class DatabaseConnection {

    // ⚠️ IMPORTANT: UPDATE THESE VALUES!
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";  // ⚠️ CHANGE THIS!

    /**
     * Get a connection to the database
     * @return Connection object or null if failed
     */
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to database!");

        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            System.out.println("Error: " + e.getMessage());
        }

        return connection;
    }

    /**
     * Close database connection safely
     * @param connection Connection to close
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("🔒 Connection closed.");
            } catch (SQLException e) {
                System.out.println("⚠️ Error closing connection!");
                e.printStackTrace();
            }
        }
    }
}