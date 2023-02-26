package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Payment;
import co.tz.vodacom.bujikun.flyaway.entity.Place;
import co.tz.vodacom.bujikun.flyaway.entity.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAO implements IDAO<User>{
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
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void create(User user) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.persist(user);
        }catch (Exception e){

        }
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, User user) {
        user.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.merge(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.remove(findOneById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        session.getTransaction().commit();
    }
}
