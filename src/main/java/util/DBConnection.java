package util;

import snaq.db.ConnectionPool;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by pardhamavilla on 11/7/16.
 */
public class DBConnection {
    private static DBConnection dbSingleton = null;
    private static ConnectionPool pool = null;
    private long idleTimeout;
    private boolean flag = true; //true: connection open, false: bad or no connection

    /**
     * A private Constructor prevents any other class from instantiating.
     */
    private DBConnection() {
        Class<?> c = null;
        try {
            c = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            flag = false;
        }

        Driver driver = null;
        try {
            driver = (Driver) c.newInstance();
        } catch (InstantiationException e) {
            flag = false;
        } catch (IllegalAccessException e) {
            flag = false;
        }
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            flag = false;
        }
        if (flag) {
            String name = "Local"; // Pool name.
            int minPool = 1; // Minimum number of pooled connections, or 0 for none.
            int maxPool = 3; // Maximum number of pooled connections, or 0 for none.
            int maxSize = 10; // Maximum number of possible connections, or 0 for no limit.
            idleTimeout = 30; // Idle timeout (seconds) for idle pooled connections, or 0 for no timeout.
            String url = "jdbc:mysql://localhost:3309/db"; // JDBC connection URL.
            String username = "senecaBBB"; // Database username.
            String password = "db"; // Password for the database username supplied.
            try {
                pool = new ConnectionPool(name, minPool, maxPool, maxSize, idleTimeout, url, username, password);
            } finally {
                pool.registerShutdownHook();
            }
        }
    }

    /**
     * Static 'instance' method
     */
    public static DBConnection getInstance() {
        if (dbSingleton == null) {
            dbSingleton = new DBConnection();
        }
        return dbSingleton;
    }

    public Connection openConnection() {
        Connection conn = null;
        try {
            conn = pool.getConnection(idleTimeout);
            flag = true;
        } catch (SQLException e) {
            flag = false;
        }
        return conn;
    }

    public boolean getConnectionStatus() {
        return flag;
    }
}