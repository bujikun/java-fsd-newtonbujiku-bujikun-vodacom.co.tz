<%--
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
                                <a class="nav-link btn btn-success" aria-current="page" href="#"
                                   style="color: #ffffff;">Admin Login</a>
                            </li>
                        </ul>
                        <form class="d-flex">
                            <input class="form-control me-2" type="search" placeholder="Booking Number"
                                   aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
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
                <div class="m-1 p-2">
                    <span class="h4 text-success">Available Flights
                       <span class="material-icons-outlined" style="font-size: 2rem;">connecting_airports</span></span>
                </div>
                <div class="px-2 mx-2">
                    <span class="h6 text-success" style="display: block;text-align: start;">From Moscow to Madrid on 02/23/2023</span></div>
                <div class="fa-form-container m-2">
                    <div class="list-group">
                        <a href="passenger-registration" class="list-group-item list-group-item-action" aria-current="true">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1">Emirates</h5>
                                <small>EK25</small>
                            </div>
                            <p class="mb-1">Departure: 14:25 &nbsp;
                                <span class="material-icons-outlined">flight</span>
                                &nbsp;Arrival: 21:00</p>
                            <small>Price : $500</small>
                        </a>
                        <a href="#" class="list-group-item list-group-item-action" aria-current="true">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1">Air India</h5>
                                <small>EK25</small>
                            </div>
                            <p class="mb-1">Departure: 14:25 &nbsp;
                                <span class="material-icons-outlined">flight</span>
                                &nbsp;Arrival: 21:00</p>
                            <small>Price : $500</small>
                        </a>
                        <a href="#" class="list-group-item list-group-item-action" aria-current="true">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1">KLM</h5>
                                <small>EK25</small>
                            </div>
                            <p class="mb-1">Departure: 14:25 &nbsp;
                                <span class="material-icons-outlined">flight</span>
                                &nbsp;Arrival: 21:00</p>
                            <small>Price : $500</small>
                        </a>
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