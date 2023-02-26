package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Airline;
import co.tz.vodacom.bujikun.flyaway.entity.Booking;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookingDAO implements IDAO<Booking> {
    private final SessionFactory sessionFactory;

    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }
    @Override
    public List<Booking> findAll() {
        var session = sessionFactory.openSession();
        TypedQuery<Booking> query = session.createQuery("SELECT b FROM Booking b",Booking.class);
        return query.getResultList();
    }

    @Override
    public Booking findOneById(Integer id) {
        var session = sessionFactory.openSession();
        TypedQuery<Booking> query = session.createQuery("SELECT b FROM Booking b WHERE b.id=:id",Booking.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void create(Booking booking) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.persist(booking);
        }catch (Exception e){

        }
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Booking booking) {
        booking.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.merge(booking);
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
