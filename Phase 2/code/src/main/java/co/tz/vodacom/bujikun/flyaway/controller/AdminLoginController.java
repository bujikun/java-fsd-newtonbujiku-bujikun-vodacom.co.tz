package co.tz.vodacom.bujikun.flyaway.controller;

import co.tz.vodacom.bujikun.flyaway.service.FlightService;
import co.tz.vodacom.bujikun.flyaway.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/login")
public class AdminLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("admin-login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("admin-home").forward(req,resp);
        var username = req.getParameter("username").trim();
        var password = req.getParameter("password").trim();
        var user = new UserService().doLogin(username,password);
        if(user==null){
            //failed login
            req.setAttribute("failed","1");
            req.getRequestDispatcher("admin-login.jsp").forward(req,resp);
            return;
        }
        var session = req.getSession();
            session.setAttribute("user",user);
       resp.sendRedirect("admin-home");
    }
}
