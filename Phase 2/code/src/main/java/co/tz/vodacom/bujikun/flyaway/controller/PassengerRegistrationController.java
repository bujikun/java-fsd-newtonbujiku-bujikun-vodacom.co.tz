package co.tz.vodacom.bujikun.flyaway.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="PassengerRegistration",value = "/passenger-registration")
public class PassengerRegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var flightId = req.getParameter("flight");
        req.setAttribute("flight",flightId);
        req.getRequestDispatcher("passenger-registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("flight-details.jsp").forward(req,resp);
    }
}
