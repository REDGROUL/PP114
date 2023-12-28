package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private static final Connection connect = new Util().getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate("CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, name varchar(64), lastName varchar(64), age tinyint)");
            System.out.println("Database has been created!");
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
    }

    public void dropUsersTable() {
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate("drop table users");
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            String sql = "INSERT INTO users (`name`, `lastname`, `age`) VALUES ((?), (?), (?))";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3,age);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
    }

    public void removeUserById(long id) {

        try {
            String sql = "DELETE FROM users WHERE `id` = (?)";
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setLong(1 , id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                User u = new User();
                u.setId(Long.parseLong(rs.getString("id")));
                u.setName(rs.getString("name"));
                u.setLastName(rs.getString("lastName"));
                u.setAge(Byte.parseByte(rs.getString("age")));
                users.add(u);
            }


        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
        return users;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate("TRUNCATE users");
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }

    }
}
