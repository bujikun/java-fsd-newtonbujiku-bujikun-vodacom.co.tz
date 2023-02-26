package co.tz.vodacom.bujikun.flyaway.controller;

import co.tz.vodacom.bujikun.flyaway.entity.Passenger;
import co.tz.vodacom.bujikun.flyaway.service.FlightService;
import co.tz.vodacom.bujikun.flyaway.service.PassengerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

@WebServlet(name="ShowBookingDetails",value = "/flight-details")
public class ShowFlightDetailsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var firstName = req.getParameter("firstname");
        var lastName = req.getParameter("lastname");
        var dOB = req.getParameter("dob");
        var address = req.getParameter("address");
        var flightId = req.getParameter("flight-id");
        var passengerId = new PassengerService().createAndGetId(
                Passenger.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .address(address)
                        .dateOfBirth(LocalDate.parse(dOB)).build()
        );
        req.setAttribute("flight",new FlightService().findOneById(Integer.valueOf(flightId)));
        req.setAttribute("passenger-id",passengerId);
        req.setAttribute("booking-number",generateBookingNumber());
        req.getRequestDispatcher("flight-details.jsp").forward(req,resp);
    }
    public String generateBookingNumber(){
        var random = new Random();
        var n = random.nextInt();
        return Integer.toHexString(n).toUpperCase();
    }
}
