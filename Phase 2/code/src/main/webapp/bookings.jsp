<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.Flight" %>
<%@ page import="java.util.List" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.User" %>
<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.Booking" %>
<%@ page import="java.awt.print.Book" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="style.jsp"></jsp:include>
    <title>Admin Panel</title>
    <style>
        .fa-form-container{
            background-color: #fff;
            box-shadow: 0 .5rem .5rem rgba(0,0,0,.2);
            width: 100%;
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
                                <a class="nav-link btn  mx-2"  aria-current="page" href="flights"
                                >Flights</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2"  aria-current="page" href="airlines"
                                >Airlines</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2 active"  aria-current="page" href="bookings"
                                >Bookings</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2"  aria-current="page" href="places"
                                >Places</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2"  aria-current="page" href="passengers"
                                >Passengers</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2"  aria-current="page" href="change-password"
                                >Change Password</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2"  aria-current="page" href="logout"
                                >Log Out</a>
                            </li>
                        </ul>
                        <div class="d-flex" action="login" method="post">
                            <span style="color: white">Hi!,<%= ((User)session.getAttribute("user")).getUsername().toUpperCase()%></span>
                        </div>
                    </div>
                </div>
            </nav>
        </div><!-- Nav bar-->
    </div>    <div class="row">
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
        <div class="col-md-8 col-lg-8 col-xl-8">
            <div class="d-flex flex-column justify-content-center align-items-center">
                <div class="m-2 p-2">
                    <h4 class="text-success">Bookings Made
                       <span class="material-icons-outlined" style="font-size: 2rem;">bookmark_border</span></h4>
                </div>
                <div class="fa-form-container m-2">
                    <div class="list-group">
                        <% for(Booking booking:(List<Booking>) request.getAttribute("bookings")){%>
                        <a class="list-group-item list-group-item-action" aria-current="true">
                            <div class="d-flex flex-column w-100 justify-content-between">
                                <h5 class="mb-2">Booking Number: <%= booking.getBookingNumber()%></h5>
<%--                                <small><%=booking.getAirline().getCodename()%></small>--%>
                                <p class="mb-1">Passenger: <span><%=booking.getPassenger().toString()%></span> &nbsp;
                                <p class="mb-1">Flight: <span><%=booking.getFlight().toString()%></span></p>
                                <p class="mb-1">Payment: <span><%=booking.getPayment().toString()%></span> &nbsp;
                            </div>


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