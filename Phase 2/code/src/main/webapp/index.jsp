<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/outlined.css" crossorigin="anonymous">
    <link rel="preload" href="font/source-code-pro/SourceCodePro-ExtraLight.ttf" as="font" type="font/ttf"
          crossorigin="anonymous">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="css/base.css">
    <title>Welcome to FlyAway</title>
    <style>
        @font-face {
            font-family: "source-code-regular";
            src: url("font/source-code-pro/SourceCodePro-Regular.ttf");
        }
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
                <div class="m-2 p-2">
                    <span class="display-6 text-success">Welcome to FlyAway
                       <span class="material-icons-outlined" style="font-size: 2rem;">connecting_airports</span></span>
                </div>
                <div class="fa-form-container m-2 p-4">
                    <h5 class="h5">Book a Flight Today</h5>
                    <form action="#" method="post" class="p-2">
                        <div class="mb-3">
                            <label for="datepicker" class="form-label">Departure</label>
                            &nbsp;<span class="material-icons-outlined">calendar_month</span>
                            <input type="date" class="form-control" id="datepicker" value="2023-02-27"
                                   min="2023-01-01" max="2023-12-31" required>
                        </div>
                        <div class="mb-3">
                                <label for="source" class="form-label">Source</label>&nbsp;<span class="material-icons-outlined">
                            flight_takeoff</span>
                            <select class="form-select" id="source" required>
                                <option value="1">Madrid</option>
                                <option value="2">London</option>
                                <option value="3">Paris</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="destination" class="form-label">Destination</label>&nbsp;<span class="material-icons-outlined">
flight_land
</span>
                            <select class="form-select" id="destination" required>
                                <option value="1">Moscow</option>
                                <option value="2">Kiev</option>
                                <option value="3">Lisbon</option>
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
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.js"></script>
<script src="js/base.js"></script>
</body>
</html>