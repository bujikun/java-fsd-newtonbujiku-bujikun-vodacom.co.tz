package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Passenger;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.util.List;

public class PassengerDAO implements IDAO<Passenger> {
    private final SessionFactory sessionFactory;

    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }

    @Override
    public List<Passenger> findAll() throws Exception {
        var session = sessionFactory.openSession();
        TypedQuery<Passenger> query = session.createQuery("SELECT p FROM Passenger p", Passenger.class);
        return query.getResultList();
    }

    @Override
    public Passenger findOneById(Integer id) throws Exception {
        var session = sessionFactory.openSession();
        TypedQuery<Passenger> query = session.createQuery("SELECT p FROM Passenger p WHERE p.id=:id", Passenger.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Passenger passenger) throws Exception {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(passenger);
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Passenger passenger) throws Exception {
        passenger.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(passenger);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) throws Exception {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(findOneById(id));
        session.getTransaction().commit();
    }

    public int createAndGetId(Passenger passenger) throws Exception {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(passenger);
        var pmt = (Integer) session.getIdentifier(passenger);
        session.getTransaction().commit();
        return pmt.intValue();
    }
}
