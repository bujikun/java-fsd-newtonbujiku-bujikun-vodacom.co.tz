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