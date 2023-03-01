package co.tz.vodacom.bujikun.flyaway.controller;

import co.tz.vodacom.bujikun.flyaway.entity.User;
import co.tz.vodacom.bujikun.flyaway.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getSession().setAttribute("user",null);
           Arrays.stream( req.getCookies()).forEach(c->{
               c.setValue("");
               c.setPath("/flyaway");
               c.setMaxAge(0);
               resp.addCookie(c);
            });
           resp.addCookie(new Cookie("JSESSIONID",""));
        req.getSession().invalidate();
        resp.sendRedirect("/flyaway");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}