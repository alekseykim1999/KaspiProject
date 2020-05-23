package kz.kaspi.lab.db;

import kz.kaspi.lab.error.Error;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class DBConnector {

    private static final String ERROR_1 = "Код ошибки не может быть пустым";
    private static final DBConnector instance = new DBConnector();


    private String instanceName;
    private String databaseName;
    private String userName;
    private String pass;
    private String connectionUrl;
    private String connectionString;

    private Connection connection;


    public DBConnector()
    {
        instanceName = "NEWSERVER\\DESKTOP-OT44A5H";
        databaseName = "PhoneBook";
        userName = "Алексей";
        pass = "123";
        connectionUrl = "jdbc:sqlserver://%1$s;databaseName=PhoneBook;user=Алексей;password=123;";
        connectionString = String.format(connectionUrl, instanceName, databaseName, userName, pass);
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (Exception e) {
                Error.printError(e);
            }
        }
    }

    public static DBConnector getDBConnector()
    {
        return instance;
    }
    public Connection getConnection()
    {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

}
