
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="style.jsp"></jsp:include>
    <title>ERROR</title>
<style>
    .fa-form-container {
        width: 100%;
    }
</style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
        <div class="col-md-8 col-lg-8 col-xl-8">
            <div class="d-flex flex-column justify-content-center align-items-center mt-4">

                <div class="fa-form-container m-2 p-4 bg-danger">
                    <h1 class="text-white m-3 p-3 display-4">ERROR 404</h1>
                    <h4 class="text-white m-2 p-4">
                        Ooops! Resource not Found!
                    </h4>
                </div>
                <span class="display-6 mt-4">Click here to go back <a href="/flyaway" class="text-success">Home</a></span>
            </div>
        </div>
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
    </div>

</div>
<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>