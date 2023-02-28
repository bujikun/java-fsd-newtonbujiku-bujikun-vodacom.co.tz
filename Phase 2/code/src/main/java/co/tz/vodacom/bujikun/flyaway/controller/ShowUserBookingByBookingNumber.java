package co.tz.vodacom.bujikun.flyaway.controller;

import co.tz.vodacom.bujikun.flyaway.entity.Booking;
import co.tz.vodacom.bujikun.flyaway.entity.Payment;
import co.tz.vodacom.bujikun.flyaway.service.BookingService;
import co.tz.vodacom.bujikun.flyaway.service.FlightService;
import co.tz.vodacom.bujikun.flyaway.service.PassengerService;
import co.tz.vodacom.bujikun.flyaway.service.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

@WebServlet("/show-booking-details-by-number")
public class ShowUserBookingByBookingNumber extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var booking = new BookingService().findOneByBookingNumber(req.getParameter("booking-number").trim());
        if (booking == null) {
            req.getSession().setAttribute("search-failed","1");
            resp.sendRedirect("/flyaway");
            return;
        }
        req.setAttribute("passenger", booking.getPassenger());
        req.setAttribute("flight", booking.getFlight());
        req.setAttribute("booking", booking);
        req.getRequestDispatcher("show-booking-details.jsp").forward(req, resp);
    }

}
