package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Payment;
import co.tz.vodacom.bujikun.flyaway.entity.Place;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.util.List;

public class PlaceDAO  implements IDAO<Place> {
    private final SessionFactory sessionFactory;

    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }
    @Override
    public List<Place> findAll() {
        var session = sessionFactory.openSession();
        TypedQuery<Place> query = session.createQuery("SELECT p FROM Place p", Place.class);
        return query.getResultList();
    }

    @Override
    public Place findOneById(Integer id) {
        var session = sessionFactory.openSession();
        TypedQuery<Place> query = session.createQuery("SELECT p FROM Place p WHERE p.id=:id", Place.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void create(Place place) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.persist(place);
        }catch (Exception e){

        }
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Place place) {
        place.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.merge(place);
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
