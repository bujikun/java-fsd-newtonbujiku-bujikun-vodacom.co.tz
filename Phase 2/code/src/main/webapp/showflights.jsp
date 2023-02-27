<%@ page import="java.util.List" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.Flight" %><%--
  Created by IntelliJ IDEA.
  User: newtonbujiku
  Date: 2/23/23
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="style.jsp"></jsp:include>
    <title>Welcome to FlyAway</title>

</head>
<body>
<div class="container">
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="row">
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
        <div class="col-md-8 col-lg-8 col-xl-8">
            <div class="d-flex flex-column justify-content-center align-items-center">
                <div class="m-1 p-2">
                    <span class="h4 text-success">Available Flights
                       <span class="material-icons-outlined" style="font-size: 2rem;">connecting_airports</span></span>
                </div>
                <div class="px-2 mx-2">
                    <span class="h6 text-success" style="display: block;text-align: start;">From <%=request.getAttribute("source") %> to
                        <%=request.getAttribute("destination") %> on <%=request.getAttribute("date") %></span></div>
                <div class="fa-form-container m-2">
                    <% if(((List<Flight>)request.getAttribute("flights")).size()<= 0 ){%>
                    <div class="p-4">
                        <h5 class="text-danger p-4">No Available Flights From the Selections!<br/>
                            Please refine your search.
                        </h5>
                    </div>
                    <%}%>
                    <div class="list-group">
                        <% for(Flight flight:(List<Flight>) request.getAttribute("flights")){%>
                        <a href="passenger-registration?flight=<%= flight.getId()%>" class="list-group-item list-group-item-action" aria-current="true">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1"><%= flight.getAirline().getName()%></h5>
                                <small><%=flight.getAirline().getCodename()%></small>
                            </div>
                            <p class="mb-1">Departure: <span><%=flight.getDeparture()%></span> &nbsp;
                                <span class="material-icons-outlined">flight</span>
                                &nbsp;Arrival: <span><%=flight.getArrival()%></span></p>
                            <small>Price : $<span><%=flight.getPrice()%></span></small>
                        </a>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
    </div>

</div>
<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>