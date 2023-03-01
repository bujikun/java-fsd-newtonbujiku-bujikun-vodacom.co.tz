<%@ page import="java.util.List" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.Flight" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.service.FlightService" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.Place" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.service.PlaceService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="style.jsp"></jsp:include>
    <title>Welcome to FlyAway</title>

</head>
<body>
<div class="container">
    <div class="row mt-2 mb-3">
        <div> <!-- Nav bar-->
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <button class="nav-link btn btn-outline-success mx-2" id="login-button" aria-current="page" href="login"
                                >Admin Login</button>
                            </li>
                        </ul>
                        <form class="d-flex" action="show-booking-details-by-number" method="post">
                            <input class="form-control me-2" type="search" placeholder="Booking Number"
                                   aria-label="Search" name="booking-number">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div><!-- Nav bar-->
    </div>    <div class="row">
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
        <div class="col-md-8 col-lg-8 col-xl-8">
            <% if(session.getAttribute("search-failed")!= null && session.getAttribute("search-failed").equals("1") ){%>
            <div class="alert alert-danger alert-dismissible fade show p-2" role="alert">
                <span>Invalid booking number! Please try again using a different number.</span>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%}%>
            <div class="d-flex flex-column justify-content-center align-items-center">
                <div class="m-2 p-2">
                    <span class="display-6 text-success">Welcome to FlyAway
                       <span class="material-icons-outlined" style="font-size: 2rem;">connecting_airports</span></span>
                </div>
                <div class="fa-form-container m-2 p-4">
                    <h5 class="h5 my-2 my-2">Book a Flight Today</h5>
                    <div id="error">

                    </div>
                    <form action="show-flights" method="post" class="p-2" name="validate-flight-form" onsubmit="return validateFlightForm()">
                        <div class="mb-3">
                            <label for="datepicker" class="form-label">Departure</label>
                            &nbsp;<span class="material-icons-outlined">calendar_month</span>
                            <input type="date" class="form-control" id="datepicker"
                                   value="<%= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) %>"
                                   min="2023-02-25" max="2023-03-10" name="date" required>
                        </div>
                        <div class="mb-3">
                            <label for="source" class="form-label">Source</label>&nbsp;<span
                                class="material-icons-outlined">
                            flight_takeoff</span>
                            <%! List<Place> places = new PlaceService().findAll();%>
                            <select class="form-select" id="source" name="source" required>
                                <% for(int i=0; i<places.size();i++){%>
                                <option value="<%= places.get(i).getId()%>">
                                    <%= places.get(i).getName()%>
                                </option>
                                <%}%>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="destination" class="form-label">Destination</label>&nbsp;<span
                                class="material-icons-outlined">flight_land</span>
                            <select class="form-select" id="destination" name="destination" required>
                                <% for(int i=0; i<places.size();i++){%>
                                <option value="<%= places.get(i).getId()%>">
                                    <%= places.get(i).getName()%>
                                </option>
                                <%}%>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-outline-success form-control">Find Flight</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
    </div>

</div>
<jsp:include page="scripts.jsp"></jsp:include>
<jsp:include page="validate-flight.jsp"></jsp:include>

</body>
</html>