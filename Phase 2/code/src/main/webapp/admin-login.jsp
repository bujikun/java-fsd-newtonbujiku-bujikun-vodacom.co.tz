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
                                <button class="nav-link btn btn-outline-success mx-2" id="home-button" aria-current="page" href="/flyaway"
                                >Home</button>
                            </li>
                        </ul>
                        <form class="d-flex" action="login" method="post">
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
                    <span class="display-6 text-success">Admin Login
                       <span class="material-icons-outlined" style="font-size: 2rem;">admin_panel_settings</span></span>
                </div>
                <div class="fa-form-container m-2 p-4">
                    <% if(request.getAttribute("failed")!= null && request.getAttribute("failed").equals("1") ){%>
                        <div class="alert alert-danger alert-dismissible fade show p-2" role="alert">
                            <span>Invalid username or password!</span>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    <%}%>
<%--                    <h5 class="h5 my-2 my-2">Admin</h5>--%>
                    <form action="login" method="post" class="p-2">
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            &nbsp;<span class="material-icons-outlined">person</span>
                            <input type="text" class="form-control" id="username" placeholder="Enter username"
                               name="username"  required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            &nbsp;<span class="material-icons-outlined">lock</span>
                            <input type="text" class="form-control" id="password" placeholder="Enter password"
                                   name="password" required>
                        </div>
                        <button type="submit" class="btn btn-outline-success form-control">Log In</button>
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