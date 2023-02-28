package co.tz.vodacom.bujikun.flyaway.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter(urlPatterns = {
        "/admin-home","/flights","/airlines","/bookings","/places","/passengers","/change-password"
})
/**
 * Restricts admin pages to be only after login
 */
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var req = (HttpServletRequest) request;
        var resp = (HttpServletResponse) response;
        if(req.getSession().getAttribute("user")==null){
            //not logged in
            resp.sendRedirect("login");
            return;
        }
        chain.doFilter(request, response);

    }
}
