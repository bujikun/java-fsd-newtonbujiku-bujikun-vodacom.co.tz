package co.tz.vodacom.bujikun.flyaway.controller;

import co.tz.vodacom.bujikun.flyaway.entity.Airline;
import co.tz.vodacom.bujikun.flyaway.entity.Flight;
import co.tz.vodacom.bujikun.flyaway.service.AirlineService;
import co.tz.vodacom.bujikun.flyaway.service.FlightService;
import co.tz.vodacom.bujikun.flyaway.service.PlaceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/add-flight")
public class AddFlightController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add-flight.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var airlineId = Integer.valueOf(req.getParameter("airline").trim());
        var price = Double.valueOf(req.getParameter("price").trim());
        var date = LocalDate.parse(req.getParameter("date").trim());
        var departure = LocalTime.parse(req.getParameter("departure").trim());
        var arrival = LocalTime.parse(req.getParameter("arrival").trim());
        var sourceId = Integer.valueOf(req.getParameter("source").trim());
        var destinationId = Integer.valueOf(req.getParameter("destination").trim());
        var code = req.getParameter("code").trim();


        var flight = Flight.builder().airline(new AirlineService().findOneById(airlineId))
                .price(price)
                .date(date)
                .code(code)
                .departure(departure)
                .arrival(arrival)
                .placeSource(new PlaceService().findOneById(sourceId))
                .placeDest(new PlaceService().findOneById(destinationId)).build();

        new FlightService().create(flight);
        resp.sendRedirect("admin-home");
    }
}