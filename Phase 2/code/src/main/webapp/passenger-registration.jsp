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
                <div class="m-2 p-2">
                    <span class="display-6 text-success">Passenger Registration
                       <span class="material-icons-outlined" style="font-size: 2rem;">connecting_airports</span></span>
                </div>
                <div class="fa-form-container m-2 p-4">
                    <h5 class="h5 my-2 my-2">Enter Passenger Details</h5>
                    <form action="flight-details" method="post" class="p-2">
                        <input type="hidden" name="flight-id" value="<%= request.getAttribute("flight").toString()%>">
                        <div class="mb-3">
                            <label for="firstname" class="form-label">First Name</label>
                            &nbsp;<span class="material-icons-outlined">badge</span>
                            <input type="text" class="form-control" id="firstname" placeholder="Enter firstname"
                               name="firstname"  required>
                        </div>
                        <div class="mb-3">
                            <label for="lastname" class="form-label">Last Name</label>
                            &nbsp;<span class="material-icons-outlined">badge</span>
                            <input type="text" class="form-control" id="lastname" placeholder="Enter firstname"
                                   name="lastname"  required>
                        </div>
                        <div class="mb-3">
                            <label for="dob" class="form-label">Departure</label>
                            &nbsp;<span class="material-icons-outlined">calendar_month</span>
                            <input type="date" class="form-control" id="dob" value="1995-02-27"
                                   min="1950-01-01" max="2004-12-31" name="dob" required>
                        </div>
                        <div class="mb-3">
                            <label for="address" class="form-label">Address</label>
                            &nbsp;<span class="material-icons-outlined">home</span>
                            <input type="text" class="form-control" id="address" placeholder="Enter Address"
                                   name="address"     required>
                        </div>
                        <button type="submit" class="btn btn-outline-success form-control">Submit</button>
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