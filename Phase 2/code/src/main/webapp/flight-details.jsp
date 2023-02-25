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
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="row">
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
        <div class="col-md-8 col-lg-8 col-xl-8">
            <div class="d-flex flex-column justify-content-center align-items-center">
                <div class="m-1 p-2">
                    <span class="h4 text-success">Flight Details
                       <span class="material-icons-outlined" style="font-size: 2rem;">connecting_airports</span></span>
                </div>
                <div class="fa-booking fa-form-container m-2 p-2 my-1" >
                    <span class="d-block">BOOKING</span>
                    <span class="d-block">Number: H2424A</span>
                </div>

                <div class="fa-booking fa-form-container m-2 p-2 my-1" >
                    <span class="d-block">AIRLINE</span>
                    <small class="d-block">Name: Emirates</small>
                </div>
                <div class="fa-booking fa-form-container m-2 p-2 my-1" >
                    <span class="d-block">FLIGHT</span>
                    <small class="d-block">From: Madrid</small>
                    <small class="d-block">To: Moscow</small>
                    <small class="d-block">Departure: 14:25</small>
                    <small class="d-block">Arrival: 20:25</small>
                    <small class="d-block">Flight Number: EK25</small>
                </div>
                <div class="fa-booking fa-form-container m-2 p-2 my-1" >
                    <span class="d-block">PRICE</span>
                    <small class="d-block">$500</small>
                </div>
                    <form action="making-payment" method="post" style="width: 80%;" class="mt-4">
                    <button class="btn btn-outline-success fa-form-container" type="submit" style="width: 100%;">Make Payment</button>
                    </form>
            </div>

        </div>
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
    </div>

</div>
<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>