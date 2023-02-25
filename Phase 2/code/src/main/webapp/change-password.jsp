<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="style.jsp"></jsp:include>
    <title>Admin Panel</title>
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
                                <a class="nav-link btn  mx-2"  aria-current="page" href="#"
                                >Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2"  aria-current="page" href="#"
                                >Flights</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2"  aria-current="page" href="#"
                                >Airlines</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2"  aria-current="page" href="#"
                                >Places</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link btn  mx-2 active"  aria-current="page" href="#"
                                >Change Password</a>
                            </li>
                        </ul>
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
                    <span class="display-6 text-success">Available Flights
                       <span class="material-icons-outlined" style="font-size: 2rem;">connecting_airports</span></span>
            </div>
        </div>
        <div class="fa-form-container m-2 p-4">
            <%--                    <h5 class="h5 my-2 my-2">Admin</h5>--%>
            <form action="change-password" method="post" class="p-2">
                <div class="mb-3">
                    <label for="opassword" class="form-label">Old Password</label>
                    &nbsp;<span class="material-icons-outlined">lock</span>
                    <input type="text" class="form-control" id="opassword" placeholder="Enter old password"
                           name="opassword"  >
                </div>
                <div class="mb-3">
                    <label for="npassword" class="form-label">New Password</label>
                    &nbsp;<span class="material-icons-outlined">lock</span>
                    <input type="text" class="form-control" id="npassword" placeholder="Enter new password"
                           name="npassword"  >
                </div>
                <div class="mb-3">
                    <label for="cpassword" class="form-label">Password</label>
                    &nbsp;<span class="material-icons-outlined">lock</span>
                    <input type="text" class="form-control" id="cpassword" placeholder="Confirm new password"
                           name="cpassword"  >
                </div>
                <button type="submit" class="btn btn-outline-success form-control">Change Password</button>
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