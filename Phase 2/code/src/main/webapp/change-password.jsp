<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.User" %>
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
                                <a class="nav-link btn  mx-2" aria-current="page" href="flights"
                                >Flights</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn  mx-2" aria-current="page" href="airlines"
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
                                <a class="nav-link btn  mx-2 active" aria-current="page" href="change-password"
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
    </div>
    <div class="row">
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
        <div class="col-md-8 col-lg-8 col-xl-8">
            <div class="d-flex flex-column justify-content-center align-items-center">
                <div class="m-2 p-2">
                    <span class="display-6 text-success">Change Password
                       <span class="material-icons-outlined" style="font-size: 2rem;">lock_open</span></span>
                </div>
                <div id="error">

                </div>
                <div class="fa-form-container m-2 p-4">
                    <% if(request.getAttribute("failed")!= null && request.getAttribute("failed").equals("1") ){%>
                    <div class="alert alert-danger alert-dismissible fade show p-2" role="alert">
                        <span>Can not change password, incorrect old password</span>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    <%}%>
                    <form action="change-password" method="post" class="p-2" onsubmit="return validateForm()"
                          name="chpwd-form">
                        <div class="mb-3">
                            <label for="opassword" class="form-label">Old Password</label>
                            &nbsp;<span class="material-icons-outlined">lock</span>
                            <input type="password" class="form-control" id="opassword" placeholder="Enter old password"
                                   name="opassword" required>
                        </div>
                        <div class="mb-3">
                            <label for="npassword" class="form-label">New Password</label>
                            &nbsp;<span class="material-icons-outlined">lock</span>
                            <input type="password" class="form-control" id="npassword" placeholder="Enter new password"
                                   name="npassword" required>
                        </div>
                        <div class="mb-3">
                            <label for="cpassword" class="form-label">Password</label>
                            &nbsp;<span class="material-icons-outlined">lock</span>
                            <input type="password" class="form-control" id="cpassword" placeholder="Confirm new password"
                                   name="cpassword" required>
                        </div>
                        <button type="submit" class="btn btn-outline-success form-control">Change Password</button>
                    </form>
                </div>
            </div>


        </div>
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
    </div>

</div>
<jsp:include page="scripts.jsp"></jsp:include>
<script>
    const validateForm = () => {
        let npassword = document.forms["chpwd-form"]["npassword"].value;
        let cpassword = document.forms["chpwd-form"]["cpassword"].value;
        if (npassword.length < 6 || cpassword.length < 6) {
            $("#error").append(`<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <span>Password length must be more than 8 characters</span>
</div>`);
            return false;
        }

        if (cpassword !== npassword) {
            $("#error").append(`<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <span>Passwords  must match</span>
</div>`);
            return false;

        }
        return true;
    };
</script>
</body>
</html>