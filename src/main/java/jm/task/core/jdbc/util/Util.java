package jm.task.core.jdbc.util;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {

    private Connection connection;

    public Util() {
        String host = "localhost";
        String dbName = "kata";
        String username = "root";
        String password = "Ripazha32.";
        this.getConnection(username, password);
    }



    public void getConnection(String username, String password) {


        String url = "jdbc:mysql://localhost/kata";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {

            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex.getMessage());
        }


    }

    public Connection getConnection() {
        return connection;
    }



}
