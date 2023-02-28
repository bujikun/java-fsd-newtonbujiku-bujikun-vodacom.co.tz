package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Place;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class PlaceDAO implements IDAO<Place> {
    private final SessionFactory sessionFactory;

    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }

    @Override
    public List<Place> findAll() throws Exception{
        var session = sessionFactory.openSession();
        TypedQuery<Place> query = session.createQuery("SELECT p FROM Place p", Place.class);
        return query.getResultList();
    }

    @Override
    public Place findOneById(Integer id) throws Exception{
        var session = sessionFactory.openSession();
        TypedQuery<Place> query = session.createQuery("SELECT p FROM Place p WHERE p.id=:id", Place.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Place place)  throws Exception{
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(place);
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Place place) throws Exception {
        place.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(place);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer id)  throws Exception {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(findOneById(id));
        session.getTransaction().commit();
    }
}
