package com.mft.model.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    //singleton
    //one time creating object
    private static ConnectionProvider connectionProvider = new ConnectionProvider();
    //private constructor so no one could create any objects
    private ConnectionProvider() {
    }
    //to get that object
    public static ConnectionProvider getConnectionProvider() {
        return connectionProvider;
    }
    //this is not static because it's not thread safe
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "library",
                "library1");
    }
}
