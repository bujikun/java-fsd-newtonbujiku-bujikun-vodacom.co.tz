package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Booking;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class BookingDAO implements IDAO<Booking> {
    private final SessionFactory sessionFactory;

    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }

    @Override
    public List<Booking> findAll() {
        var session = sessionFactory.openSession();
        TypedQuery<Booking> query = session.createQuery("SELECT b FROM Booking b", Booking.class);
        return query.getResultList();
    }

    @Override
    public Booking findOneById(Integer id) {
        var session = sessionFactory.openSession();
        TypedQuery<Booking> query = session.createQuery("SELECT b FROM Booking b WHERE b.id=:id", Booking.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Booking booking) throws SQLException {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(booking);
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Booking booking) throws SQLException {
        booking.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(booking);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(findOneById(id));
        session.getTransaction().commit();
    }
    public Booking createAndGetByBookingNumber(String bookingNumber) throws SQLException{
        var booking = Booking.builder().bookingNumber(bookingNumber).build();
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(booking);
        var id = (Integer)session.getIdentifier(booking);
        session.getTransaction().commit();
        System.out.println(findOneById(id));
        return findOneById(id);
    }
}
