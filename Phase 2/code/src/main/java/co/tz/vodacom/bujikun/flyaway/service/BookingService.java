package co.tz.vodacom.bujikun.flyaway.service;

import co.tz.vodacom.bujikun.flyaway.dao.BookingDAO;
import co.tz.vodacom.bujikun.flyaway.entity.Booking;

import java.sql.SQLException;
import java.util.List;

public class BookingService implements IService<Booking> {
    private final BookingDAO bookingDAO;

    {
        bookingDAO = new BookingDAO();
    }

    @Override
    public List<Booking> findAll() {
        return bookingDAO.findAll();
    }

    @Override
    public Booking findOneById(Integer id) {
        return bookingDAO.findOneById(id);
    }
    public Booking findOneByBookingNumber(String bookingNumber) {
        try {
            return bookingDAO.findOneByBookingNumber(bookingNumber);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String create(Booking booking) {
        try {
            bookingDAO.create(booking);
            return "Booking Successfully Added";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Booking Could Not Be Added";
    }

    @Override
    public String update(Integer id, Booking booking) {
        try {
            bookingDAO.update(id, booking);
            return "Booking Successfully Updated";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Booking Could Not Be Updated";
    }

    @Override
    public String delete(Integer id) {
        try {
            bookingDAO.delete(id);
            return "Booking Successfully Deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Booking Could Not Be Deleted";
    }

    public Booking createAndGet(Booking booking) {
        try {
            return bookingDAO.createAndGet(booking);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
