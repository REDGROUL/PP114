package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        List<User> users = new ArrayList<>();

        users.add(new User("user1", "userln1", (byte) 19));
        users.add(new User("user2", "userln2", (byte) 20));
        users.add(new User("user3", "userln3", (byte) 21));
        users.add(new User("user4", "userln4", (byte) 22));

        users.forEach(usr->{
            userService.saveUser(usr.getName(), usr.getLastName(), usr.getAge());
            System.out.println("User с именем – " + usr.getName() + " добавлен в базу данных ");
        });

        List<User> userList = userService.getAllUsers();

        System.out.println(userList);

        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
