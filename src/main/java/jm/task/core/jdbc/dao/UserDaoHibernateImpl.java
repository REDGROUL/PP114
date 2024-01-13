package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final Session session = new Util().getSessionFactory().openSession();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction transaction = session.beginTransaction();

        try {
            session.createSQLQuery(" CREATE TABLE IF NOT EXISTS `users` (id INT PRIMARY KEY AUTO_INCREMENT, name varchar(64), lastName varchar(64), age tinyint)").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {

        Transaction transaction = session.beginTransaction();

        try {
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Transaction transaction = session.beginTransaction();

        User u = new User(name, lastName, age);
        try {
            session.save(u);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {

        Transaction transaction = session.beginTransaction();

        try {
            User remove = new User();
            remove.setId(id);

            session.delete(remove);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }


    @Override
    public List<User> getAllUsers() {
        return session.createQuery("SELECT a FROM User a", User.class).getResultList();
    }

    @Override
    public void cleanUsersTable() {

        Transaction transaction = session.beginTransaction();

        try {
            session.createSQLQuery("TRUNCATE users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
