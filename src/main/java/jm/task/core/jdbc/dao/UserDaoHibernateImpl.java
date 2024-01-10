package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final Session session = new Util().getSessionFactory().openSession();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

        try {
            session.beginTransaction();
            session.createSQLQuery(" CREATE TABLE IF NOT EXISTS `users` (id INT PRIMARY KEY AUTO_INCREMENT, name varchar(64), lastName varchar(64), age tinyint)").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {


        try {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        User u = new User(name, lastName, age);
        try {
            session.beginTransaction();
            session.save(u);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    @Override
    public void removeUserById(long id) {


        try {
            session.beginTransaction();
            User remove = new User();
            remove.setId(id);

            session.delete(remove);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


    @Override
    public List<User> getAllUsers() {
        return session.createQuery("SELECT a FROM User a", User.class).getResultList();
    }

    @Override
    public void cleanUsersTable() {

        try {
            session.beginTransaction();
            session.createSQLQuery("TRUNCATE users").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
