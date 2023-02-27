package co.tz.vodacom.bujikun.flyaway.controller;

import co.tz.vodacom.bujikun.flyaway.entity.User;
import co.tz.vodacom.bujikun.flyaway.service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/admin-home")
public class AdminHomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var user = ((User)req.getSession().getAttribute("user"));
        Logger.getLogger(this.getServletName()).info(user.toString());
        req.setAttribute("flights",new FlightService().findAll());
        req.getRequestDispatcher("admin-home.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // req.getRequestDispatcher("admin-home.jsp").forward(req,resp);
    }
}
