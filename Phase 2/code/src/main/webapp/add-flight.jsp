<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.User" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.Place" %>
<%@ page import="java.util.List" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.service.PlaceService" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.Airline" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.service.AirlineService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="style.jsp"></jsp:include>
    <title>Admin Panel</title>
    <style>
        .fa-form-container {
            background-color: #fff;
            box-shadow: 0 .5rem .5rem rgba(0, 0, 0, .2);
            width: 70%;
            border-radius: .2rem;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row mt-2 mb-3">
        <div> <!-- Nav bar-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-success">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2 active" aria-current="page" href="flights"
                                >Flights</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2 " aria-current="page" href="airlines"
                                >Airlines</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2" aria-current="page" href="bookings"
                                >Bookings</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2" aria-current="page" href="places"
                                >Places</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2" aria-current="page" href="passengers"
                                >Passengers</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2" aria-current="page" href="change-password"
                                >Change Password</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2" aria-current="page" href="logout"
                                >Log Out</a>
                            </li>
                        </ul>
                        <div class="d-flex" action="login" method="post">
                            <span style="color: white">Hi!,<%= ((User) session.getAttribute("user")).getUsername().toUpperCase()%></span>
                        </div>
                    </div>
                </div>
            </nav>
        </div><!-- Nav bar-->
    </div>
    <div class="row">
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
        <div class="col-md-8 col-lg-8 col-xl-8">
            <div class="d-flex flex-column justify-content-center align-items-center">
                <div class="m-2 p-2">
                    <h4 class="text-success">Add New Flight
                        <span class="material-icons-outlined" style="font-size: 2rem;">connecting_airports</span></h4>
                </div>
                <div class="fa-form-container m-2 p-3">
                    <form action="add-flight" method="post" class="p-2">
                        <div class="mb-3">
                            <label for="source" class="form-label">Airline</label>&nbsp;<span
                                class="material-icons-outlined">
                            airlines</span>
                            <%! List<Airline> airlines = new AirlineService().findAll();%>
                            <select class="form-select" id="source" name="airline" required>
                                <% for(int i=0; i<airlines.size();i++){%>
                                <option value="<%= airlines.get(i).getId()%>">
                                    <%= airlines.get(i).getName()%>
                                </option>
                                <%}%>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="code" class="form-label">Flight Number</label>
                            &nbsp;<span class="material-icons-outlined">tag</span>
                            <input type="text" class="form-control" id="code" placeholder="eg. For Air India AI32"
                                    name="code" required>
                        </div>
                        <div class="mb-3">
                            <label for="price" class="form-label">Price</label>
                            &nbsp;<span class="material-icons-outlined">attach_money</span>
                            <input type="number" class="form-control" id="price" placeholder="eg. 500"
                                   min="2023-02-25" max="2023-03-10" name="price" required>
                        </div>
                        <div class="mb-3">
                            <label for="datepicker" class="form-label">Date</label>
                            &nbsp;<span class="material-icons-outlined">calendar_month</span>
                            <input type="date" class="form-control" id="datepicker"
                                   min="2023-02-25" max="2023-03-10" name="date" required>
                        </div>
                        <div class="mb-3">
                            <label for="departure" class="form-label">Departure</label>
                            &nbsp;<span class="material-icons-outlined">timer</span>
                            <input type="time" class="form-control" id="departure"
                                   min="2023-02-25" max="2023-03-10" name="departure" required>
                        </div>
                        <div class="mb-3">
                            <label for="arrival" class="form-label">Arrival</label>
                            &nbsp;<span class="material-icons-outlined">timer</span>
                            <input type="time" class="form-control" id="arrival"
                                   min="2023-02-25" max="2023-03-10" name="arrival" required>
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
                        <button type="submit" class="btn btn-outline-success form-control">Submit</button>
                    </form>
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