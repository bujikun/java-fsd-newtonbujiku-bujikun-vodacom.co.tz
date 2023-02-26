package co.tz.vodacom.bujikun.flyaway.dao;

import co.tz.vodacom.bujikun.flyaway.config.DatabaseResource;
import co.tz.vodacom.bujikun.flyaway.entity.Payment;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class PaymentDAO implements IDAO<Payment> {
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
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Payment payment) throws SQLException {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(payment);
        session.getTransaction().commit();
    }

    @Override
    public void update(Integer id, Payment payment) throws SQLException {
        payment.setId(id);
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(payment);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(findOneById(id));
        session.getTransaction().commit();
    }
    public int createAndGetId(Payment payment) throws SQLException{
        var session = sessionFactory.openSession();
        session.beginTransaction();
         session.persist(payment);
         var pmt = (Integer) session.getIdentifier(payment);
        session.getTransaction().commit();
        return pmt.intValue();
    }
}
