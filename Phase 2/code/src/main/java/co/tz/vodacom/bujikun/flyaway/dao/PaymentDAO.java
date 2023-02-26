package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Payment;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.util.List;

public class PaymentDAO implements IDAO<Payment>{
    private final SessionFactory sessionFactory;

    {
        sessionFactory = DatabaseResource.getSessionFactory();
    }
    @Override
    public List<Payment> findAll() {
        var session = sessionFactory.openSession();
        TypedQuery<Payment> query = session.createQuery("SELECT p FROM Payment p", Payment.class);
        return query.getResultList();
    }

    @Override
    public Payment findOneById(Integer id) {
        var session = sessionFactory.openSession();
        TypedQuery<Payment> query = session.createQuery("SELECT p FROM Payment p WHERE p.id=:id", Payment.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void create(Payment passenger) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.persist(passenger);
        }catch (Exception e){

        }
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Payment payment) {
        payment.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            session.merge(payment);
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
