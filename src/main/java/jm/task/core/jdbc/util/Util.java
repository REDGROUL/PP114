package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

public class Util {

    private Connection connection;
    private SessionFactory sessionFactory;

    public Util() {


        String host = "localhost";
        String dbName = "kata";
        String username = "root";
        String password = "Ripazha32.";
        this.getConnection(host, dbName, username, password);
        this.getSessionFactory(host, username, password);
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


    public void getSessionFactory(String host, String username, String password) {

        try {

            Configuration configuration = new Configuration();
            Properties settings = new Properties();

            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/kata?autoReconnect=true&useSSL=false");
            settings.put(Environment.USER, username);
            settings.put(Environment.PASS, password);
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            //settings.put(Environment.FLUSH_MODE.MA, "manual");

            configuration.setProperties(settings);
            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Problem creating session factory");
            System.out.println(e.getMessage());
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
