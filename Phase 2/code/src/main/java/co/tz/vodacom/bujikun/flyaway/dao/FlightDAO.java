package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Flight;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightDAO implements IDAO<Flight> {
    private final SessionFactory sessionFactory;

    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }
    public List<Flight> findAll(LocalDate date,String source,String destination) {
        var session = sessionFactory.openSession();
        TypedQuery<Flight> query = session.createQuery("SELECT f FROM Flight f WHERE f.date=:date AND f.placeSource=:source AND f.placeDest=:destination",
                Flight.class);
        query.setParameter("date",date);
        var placeDAO = new PlaceDAO();
        query.setParameter("source",placeDAO.findOneById(Integer.valueOf(source)));
        query.setParameter("destination",placeDAO.findOneById(Integer.valueOf(destination)));
        query.getResultList().forEach(f->Logger.getLogger(this.getClass().getName()).log(Level.INFO,f.toString()));
        return query.getResultList();
    }
    @Override
    public List<Flight> findAll() {
        var session = sessionFactory.openSession();
        TypedQuery<Flight> query = session.createQuery("SELECT f FROM Flight f", Flight.class);
        query.getResultList().forEach(f->Logger.getLogger(this.getClass().getName()).log(Level.INFO,f.toString()));
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
