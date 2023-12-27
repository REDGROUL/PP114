package jm.task.core.jdbc.util;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {

    private Connection connection;

    public Util() {
        String host = "localhost";
        String dbName = "kata";
        String username = "root";
        String password = "UPass:)";
        this.getConnection(host, dbName, username, password);
    }

    public void getConnection(String host, String dbName, String username, String password) {

        String url = new StringBuilder().append("jdbc:mysql://").append(host).append("/").append(dbName).toString();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, username, password);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
