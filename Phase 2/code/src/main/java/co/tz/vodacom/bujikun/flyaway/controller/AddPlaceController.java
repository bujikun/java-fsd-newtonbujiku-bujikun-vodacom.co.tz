package co.tz.vodacom.bujikun.flyaway.controller;

import co.tz.vodacom.bujikun.flyaway.entity.Place;
import co.tz.vodacom.bujikun.flyaway.service.AirlineService;
import co.tz.vodacom.bujikun.flyaway.service.PlaceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-place")
public class AddPlaceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add-place.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var placeName = req.getParameter("place");
        new PlaceService().create(Place.builder().name(placeName).build());
        //req.getRequestDispatcher("places").forward(req,resp);
        resp.sendRedirect("places");
    }
}