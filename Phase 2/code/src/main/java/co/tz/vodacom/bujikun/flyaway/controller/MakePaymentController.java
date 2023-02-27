package co.tz.vodacom.bujikun.flyaway.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MakingPayment",value = "/making-payment")
public class MakePaymentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("passenger-registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("passenger-id",req.getParameter("passenger-id"));
        req.setAttribute("flight-id",req.getParameter("flight-id"));
        req.setAttribute("booking-number",req.getParameter("booking-number"));
        req.getRequestDispatcher("making-payment.jsp").forward(req,resp);
    }

}
