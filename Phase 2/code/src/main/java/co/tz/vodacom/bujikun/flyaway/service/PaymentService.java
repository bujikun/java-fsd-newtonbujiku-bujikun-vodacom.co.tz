package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.dao.PaymentDAO;
import co.tz.vodacom.bujikun.flyaway.entity.Payment;
import co.tz.vodacom.bujikun.flyaway.entity.Place;

import java.sql.SQLException;
import java.util.List;

public class PaymentService implements IService<Payment> {
    private final PaymentDAO paymentDAO;

    {
        paymentDAO = new PaymentDAO();
    }

    @Override
    public List<Payment> findAll() {
        return paymentDAO.findAll();
    }

    @Override
    public Payment findOneById(Integer id) {
        return paymentDAO.findOneById(id);
    }

    @Override
    public String create(Payment payment) {
        try {
            paymentDAO.create(payment);
            return "Payment Successfully Added";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Payment Could Not Be Added";
    }

    @Override
    public String update(Integer id, Payment payment) {
        try {
            paymentDAO.update(id, payment);
            return "Payment Successfully Updated";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Payment Could Not Be Updated";
    }

    @Override
    public String delete(Integer id) {
        try {
            paymentDAO.delete(id);
            return "Payment Successfully Deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Payment Could Not Be Deleted";
    }

    public int createAndGetId(Payment payment) {
        try {
            return paymentDAO.createAndGetId(payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
