package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IDAO<User> {
    private final SessionFactory sessionFactory;

    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }

    @Override
    public List<User> findAll() {
        var session = sessionFactory.openSession();
        TypedQuery<User> query = session.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User findOneById(Integer id) {
        var session = sessionFactory.openSession();
        TypedQuery<User> query = session.createQuery("SELECT u FROM User u WHERE u.id=:id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(User user) throws SQLException {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        user.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(findOneById(id));
        session.getTransaction().commit();
    }

    public User findByUsername(String username) throws Exception{
        var session = sessionFactory.openSession();
        TypedQuery<User> query = session.createQuery("SELECT u FROM User u WHERE u.username=:username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
