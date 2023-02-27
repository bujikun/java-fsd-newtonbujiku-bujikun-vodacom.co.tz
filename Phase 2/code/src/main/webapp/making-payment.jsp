<%@ page import="co.tz.vodacom.bujikun.flyaway.entity.Flight" %><%--
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
    <title>Processing Payment</title>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-2 col-lg-2 col-xl-2">

        </div>
        <div class="col-md-8 col-lg-8 col-xl-8">
            <div class="d-flex flex-column justify-content-center align-items-center mt-5">
                <div class="mt-5 p-2">
                    <span class="h4 text-success">Payment
                       <span class="material-icons-outlined" style="font-size: 2rem;">paid</span></span>
                </div>

                <div class="fa-form-container h-75 mt-5">
                    <div class="progress">
                        <div class="progress-bar bg-success" role="progressbar" style="width: 0%" aria-valuenow="0"
                             aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                </div>
                <div class="px-2 mx-2 mt-4">
                    <span class="h6 text-success" style="display: block;text-align: start;">Contacting Dummy Payment Gateway...</span>
                </div>
                <div class="fa-form-container m-2">
                    <form id="#payment-form" action="show-booking-details" method="post" class="d-none">
                        <input type="hidden" name="flight-id"
                               value=" <%=((String)request.getAttribute("flight-id"))%>">
                        <input type="hidden" name="passenger-id"
                               value=" <%=((String)request.getAttribute("passenger-id"))%>">
                        <input type="hidden" name="booking-number"
                               value=" <%=((String)request.getAttribute("booking-number"))%>">
                    </form>
                </div>
            </div>
            <div class="col-md-2 col-lg-2 col-xl-2">

            </div>
        </div>

    </div>
    <jsp:include page="scripts.jsp"></jsp:include>
    <script>
        // Set the width to animate the progress bar
        // Along with time duration in milliseconds
        $(".progress-bar").animate({
            width: "100%",
        }, 3500);
        // $("#submit").click(() => {
        //     window.location.replace("show-booking-details");
        // });
        setTimeout(() => {
            const form = document.getElementById("#payment-form");
            form.submit();
            console.log("Outside submitted");
        }, 4000);
    </script>
</body>
</html>