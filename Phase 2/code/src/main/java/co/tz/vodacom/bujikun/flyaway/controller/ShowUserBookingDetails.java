package co.tz.vodacom.bujikun.flyaway.controller;

import co.tz.vodacom.bujikun.flyaway.service.BookingService;
import co.tz.vodacom.bujikun.flyaway.service.FlightService;
import co.tz.vodacom.bujikun.flyaway.service.PassengerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/show-booking-details")
public class ShowUserBookingDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var passengerId = Integer.valueOf(req.getParameter("passenger-id").trim());
        var flightId = Integer.valueOf(req.getParameter("flight-id").trim());
        var bookingNumber = req.getParameter("booking-number").trim();
        req.setAttribute("passenger",new PassengerService().findOneById(passengerId));
        req.setAttribute("flight",new FlightService().findOneById(flightId));
        req.setAttribute("booking",new BookingService().createAndGetByBookingNumber(bookingNumber));
        req.getRequestDispatcher("show-booking-details.jsp").forward(req, resp);

    }
}
