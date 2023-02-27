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

@WebServlet(name = "ChangePassword",value = "/change-password")
public class ChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("change-password.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var opassword = req.getParameter("opassword");
        var npassword = req.getParameter("npassword");
        var user =(User) req.getSession().getAttribute("user");
        if(BCrypt.checkpw(opassword,user.getPassword())){
            //legit
            //changePassword
            user.setPassword(BCrypt.hashpw(npassword,BCrypt.gensalt(10)));
            new UserService().update(user.getId(),user);
            req.getSession().invalidate();
            req.getSession().setAttribute("user",null);
            Arrays.stream( req.getCookies()).map(c->{
                c.setValue(null);
                return c;
            }).toArray(Cookie[]::new);
            req.getRequestDispatcher("admin-login.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("failed","1");
         req.getRequestDispatcher("change-password.jsp").forward(req,resp);
    }
}