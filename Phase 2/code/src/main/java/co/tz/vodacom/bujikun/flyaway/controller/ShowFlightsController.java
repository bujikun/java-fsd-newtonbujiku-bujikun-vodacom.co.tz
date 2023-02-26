package co.tz.vodacom.bujikun.flyaway.controller;

import co.tz.vodacom.bujikun.flyaway.entity.Flight;
import co.tz.vodacom.bujikun.flyaway.service.FlightService;
import co.tz.vodacom.bujikun.flyaway.service.PlaceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/show-flights")
public class ShowFlightsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var date = LocalDate.parse(req.getParameter("date"));
        var source = req.getParameter("source");
        var destination = req.getParameter("destination");
        var flights = new FlightService().findAll(date,source,destination);
        req.setAttribute("flights",flights);
        req.setAttribute("date",date);
        req.setAttribute("source",new PlaceService().findOneById(Integer.valueOf(source)).getName());
        req.setAttribute("destination",new PlaceService().findOneById(Integer.valueOf(destination)).getName());
        req.getRequestDispatcher("showflights.jsp").forward(req,resp);
    }

}
