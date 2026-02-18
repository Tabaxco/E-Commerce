package controller.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DEFAULT_URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASS = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {
        try {
            String dbUrl = System.getenv("DB_URL");

            if (dbUrl == null || dbUrl.isEmpty()) {
                dbUrl = DEFAULT_URL;
                System.out.println("Connecting to LOCAL database...");
            } else {
                System.out.println("Connecting to DOCKER database...");
            }

            // 3. Create the connection
            return DriverManager.getConnection(dbUrl, USER, PASS);

        } catch (SQLException e) {
            System.err.println("CRITICAL: Could not connect to the database!");
            e.printStackTrace();
            // In a real app, you might want to throw a RuntimeException here
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
