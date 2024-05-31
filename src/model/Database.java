package model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Database {
    public static Connection conn = null;
    public static PreparedStatement pst;
    public static ResultSet rs;

    private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String DB_HOST = "localhost";
    private final static String DB_NAME = "dbsecond";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "";
    private final static String DB_URL = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME;;

    public Database(){
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver!");
        }
    }

    public final static Connection connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.out.println("Failed to connect database!");
            JOptionPane.showMessageDialog(null, "Gagal terhubung ke database! Pastikan database telah dinyalakan.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

    public final static void disconnect() {
        try {
            conn.close();
            System.out.println("Database disconnected!");
        } catch (SQLException e) {
            System.out.println("Failed to disconnect database!");
        }
    }
}