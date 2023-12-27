package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
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
            statement.executeUpdate("CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, name varchar(64), lastName varchar(64), age tinyint)");
            System.out.println("Database has been created!");
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }


    }

    public void dropUsersTable() {
        try {
            Statement statement = new Util().getConnection().createStatement();
            statement.executeUpdate("drop table users");
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }


    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            String sql = "INSERT INTO users (`name`, `lastname`, `age`) VALUES ((?), (?), (?))";

        //    Statement statement = new Util().getConnection().createStatement();
            PreparedStatement statement = new Util().getConnection().prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3,age);
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }

    public void removeUserById(long id) {

        try {
            String sql = "DELETE FROM users WHERE `id` = (?)";
            PreparedStatement statement = new Util().getConnection().prepareStatement(sql);
            statement.setLong(1 , id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = new Util().getConnection().createStatement();
            statement.executeUpdate("TRUNCATE users");
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }

    }
}
