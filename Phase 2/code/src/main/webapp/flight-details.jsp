<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.Flight" %><%--
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
        .fa-make-payment-btn{
            background-color: #fff;
            width: 68%;
            border-radius: .2rem;
        }
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
                    <span class="d-block">Number: <%= request.getAttribute("booking-number")%></span>
                </div>

                <div class="fa-booking fa-form-container m-2 p-2 my-1" >
                    <span class="d-block">AIRLINE</span>
                    <small class="d-block">Name: <%= ((Flight)request.getAttribute("flight")).getAirline().getName()%></small>
                </div>
                <div class="fa-booking fa-form-container m-2 p-2 my-1" >
                    <span class="d-block">FLIGHT</span>
                    <small class="d-block">From: <%= ((Flight)request.getAttribute("flight")).getPlaceSource().getName()%></small>
                    <small class="d-block">To: <%= ((Flight)request.getAttribute("flight")).getPlaceDest().getName()%></small>
                    <small class="d-block">Departure: <%= ((Flight)request.getAttribute("flight")).getDeparture()%></small>
                    <small class="d-block">Arrival: <%= ((Flight)request.getAttribute("flight")).getArrival()%></small>
                    <small class="d-block">Flight Number: <%= ((Flight)request.getAttribute("flight")).getCode()%></small>
                </div>
                <div class="fa-booking fa-form-container m-2 p-2 my-1" >
                    <span class="d-block">PRICE</span>
                    <small class="d-block">$<%= ((Flight)request.getAttribute("flight")).getPrice()%></small>
                </div>
<%--                <div class="fa-make-payment-btn mt-5 m-2 p-2 my-1">--%>
<%--                    <form action="making-payment" method="post" class="fa-make-payment-btn mt-5">--%>
<%--                        <button class="btn btn-outline-success" type="submit">Make Payment</button>--%>
<%--                    </form>--%>
<%--                </div>--%>

                <div class="fa-make-payment-btn mt-2 p-2">
                    <form action="making-payment" method="post" class="mt-3 p-2">
                        <input type="hidden" name="flight-id" value=" <%= ((Flight)request.getAttribute("flight")).getId()%>">
                        <input type="hidden" name="passenger-id" value=" <%= ((Integer)request.getAttribute("passenger-id"))%>">
                        <input type="hidden" name="booking-number" value=" <%= ((String)request.getAttribute("booking-number"))%>">
                        <button class="btn btn-outline-success" type="submit" style="width: 100%;">Make Payment</button>
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