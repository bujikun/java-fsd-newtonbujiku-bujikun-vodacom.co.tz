<%--
  Created by IntelliJ IDEA.
  User: newtonbujiku
  Date: 2/23/23
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <style>
        body{background-color: #fff;}
    </style>
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
                    <span class="h4 text-success">Your Flight Details
                       <span class="material-icons-outlined" style="font-size: 2rem;">connecting_airports</span></span>
                </div>
                <div class="bg-success fa-form-container m-2 p-2 my-1" style="color:white">
                    <span class="d-block">BOOKING</span>
                    <span class="d-block">Number: H2424A</span>
                </div>
<%--                <div class="bg-success fa-form-container m-2 p-2 my-1" style="color:white">--%>
<%--                    <span class="d-block">PASSENGER</span>--%>
<%--                    <small class="d-block">Name: Newton Bujiku</small>--%>
<%--                    <small class="d-block">DOB: 19/01/1990</small>--%>
<%--                    <small class="d-block">Address: Dar Es Salam</small>--%>
<%--                </div>--%>

                <div class="bg-success fa-form-container m-2 p-2 my-1" style="color:white">
                    <span class="d-block">AIRLINE</span>
                    <small class="d-block">Name: Emirates</small>
                </div>
                <div class="bg-success fa-form-container m-2 p-2 my-1" style="color:white">
                    <span class="d-block">FLIGHT</span>
                    <small class="d-block">From: Madrid</small>
                    <small class="d-block">To: Moscow</small>
                    <small class="d-block">Departure: 14:25</small>
                    <small class="d-block">Arrival: 20:25</small>
                    <small class="d-block">Flight Number: EK25</small>
                </div>
                <div class="bg-success fa-form-container m-2 p-2 my-1" style="color:white">
                    <span class="d-block">PRICE</span>
                    <small class="d-block">$500</small>
                </div>
                <div class="mt-4 fa-form-container">
                    <button class="btn btn-outline-success" type="submit" style="width: 100%"
                            data-bs-toggle="modal" data-bs-target="#exampleModal">Make Payment</button>
                </div>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            </div>
                            <div class="modal-body">
                                ...
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
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