package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Statement statement = null;
        try {
            statement = new Util().getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            statement.executeUpdate("CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, name varchar(64), lastName varchar(64), age bit(20))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Database has been created!");
    }

    public void dropUsersTable() {
        try {
            Statement statement = new Util().getConnection().createStatement();
            statement.executeUpdate("drop table users");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
