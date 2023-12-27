package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        //userDaoJDBC.createUsersTable();
       //userDaoJDBC.dropUsersTable();
       //userDaoJDBC.removeUserById(1);
        userDaoJDBC.cleanUsersTable();
        //userDaoJDBC.saveUser("fedor", "borisov", (byte) 22);
    }
}
