package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Airline;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.util.List;

public class AirlineDAO implements IDAO<Airline> {
    private final SessionFactory sessionFactory;
    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }
    @Override
    public List<Airline> findAll() {
        var session = sessionFactory.openSession();
        TypedQuery<Airline> query = session.createQuery("SELECT a FROM Airline a",Airline.class);
       return query.getResultList();
    }

    @Override
    public Airline findOneById(Integer id) {
        var session = sessionFactory.openSession();
        TypedQuery<Airline> query = session.createQuery("SELECT a FROM Airline a WHERE a.id=:id",Airline.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void create(Airline airline) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.persist(airline);
        }catch (Exception e){

        }
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Airline airline) {
        airline.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.merge(airline);
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
