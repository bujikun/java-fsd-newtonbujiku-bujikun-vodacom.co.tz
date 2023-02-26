package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Flight;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class FlightDAO implements IDAO<Flight> {
    private final SessionFactory sessionFactory;

    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }

    @Override
    public List<Flight> findAll() {
        var session = sessionFactory.openSession();
        TypedQuery<Flight> query = session.createQuery("SELECT f FROM Flight f", Flight.class);
        return query.getResultList();
    }

    @Override
    public Flight findOneById(Integer id) {
        var session = sessionFactory.openSession();
        TypedQuery<Flight> query = session.createQuery("SELECT f FROM Flight f WHERE f.id=:id", Flight.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Flight flight) throws SQLException {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(flight);
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Flight flight) throws SQLException {
        flight.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(flight);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(findOneById(id));
        session.getTransaction().commit();
    }
}
