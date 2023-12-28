package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//
//        userDaoJDBC.createUsersTable();
//
//        List<User> users = new ArrayList<>();
//
//        users.add(new User("user1", "userln1", (byte) 19));
//        users.add(new User("user2", "userln2", (byte) 20));
//        users.add(new User("user3", "userln3", (byte) 21));
//        users.add(new User("user4", "userln4", (byte) 22));
//
//        users.forEach(usr->{
//            userDaoJDBC.saveUser(usr.getName(), usr.getLastName(), usr.getAge());
//            System.out.println("User с именем – " + usr.getName() + " добавлен в базу данных ");
//        });
//
//        List<User> userList= userDaoJDBC.getAllUsers();
//
//        System.out.println(userList);

//        userDaoJDBC.cleanUsersTable();
//        userDaoJDBC.dropUsersTable();

    }
}
