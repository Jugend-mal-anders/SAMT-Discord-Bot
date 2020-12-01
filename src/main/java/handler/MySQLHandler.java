package handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLHandler {

    private static Connection conn;

    public static void connect() {
        String url = "jdbc:mysql://localhost:3306/bot";
        String username = "bot";
        String password = "ULTRA GEHEIMES PASSWORT";

        System.out.println("Connecting database...");

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void write(String text) {
        try {
            conn.createStatement().executeQuery("INSERT INTO ActiveVotings (idActiveVotings) VALUES ('" + text + "');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void remove(String text) {
        try {
            conn.createStatement().executeQuery("REMOVE FROM ActiveVotings WHERE ('" + text + "');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
