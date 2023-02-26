package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.dao.IDAO;
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
    public List<Passenger> findAll() {
        var session = sessionFactory.openSession();
        TypedQuery<Passenger> query = session.createQuery("SELECT p FROM Passenger p",Passenger.class);
        return query.getResultList();
    }

    @Override
    public Passenger findOneById(Integer id) {
        var session = sessionFactory.openSession();
        TypedQuery<Passenger> query = session.createQuery("SELECT p FROM Passenger p WHERE p.id=:id",Passenger.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void create(Passenger passenger) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.persist(passenger);
        }catch (Exception e){

        }
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Passenger passenger) {
        passenger.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.merge(passenger);
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
