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

@WebServlet("/show-booking-details")
public class ShowUserBookingDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var passengerId = Integer.valueOf(req.getParameter("passenger-id").trim());
        var flightId = Integer.valueOf(req.getParameter("flight-id").trim());
        var booking = Booking.builder().bookingNumber(req.getParameter("booking-number").trim()).build();

        var passenger =new PassengerService().findOneById(passengerId);
        var flight = new FlightService().findOneById(flightId);
        var payment = new PaymentService().createAndGet(Payment.builder()
                .passenger(passenger)
                .amount(flight.getPrice())
                .codename(getRandomString())
                .build());
        booking.setFlight(flight);
        booking.setPassenger(passenger);
        booking.setPayment(payment);
        booking = new BookingService().createAndGet(booking);
        req.setAttribute("passenger",passenger);
        req.setAttribute("flight",flight);
        req.setAttribute("booking",booking);

        req.getRequestDispatcher("show-booking-details.jsp").forward(req, resp);

    }

    private String getRandomString() {
        return Long.toHexString(new Random().nextLong()).toUpperCase();
    }
}
