package util;

import base.DBConfig;
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

    private DBConnection(DBConfig dbConfig) {
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
            idleTimeout = 300; // Idle timeout (seconds) for idle pooled connections, or 0 for no timeout.
            String url = dbConfig.getUrl(); // JDBC connection URL.
            String username = dbConfig.getUsername(); // Database username.
            String password = dbConfig.getPassword(); // Password for the database username supplied.
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
    public static DBConnection getInstance(DBConfig dbConfig) {
        if (dbSingleton == null) {
            init(dbConfig);
        }
        return dbSingleton;
    }

    /**
     * A private Constructor prevents any other class from instantiating.
     */

    public static void init(DBConfig dbConfig) {
        if (dbSingleton == null) {
            dbSingleton = new DBConnection(dbConfig);
        }
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