<%--
  Created by IntelliJ IDEA.
  User: newtonbujiku
  Date: 2/24/23
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>

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
                        <li class="nav-item">
                            <button class="nav-link btn btn-outline-success mx-2" id="login-button" aria-current="page" href="login"
                            >Admin Login</button>
                        </li>
                    </ul>
                    <form class="d-flex" action="show-booking-details-by-number" method="post">
                        <input class="form-control me-2" type="search" placeholder="Booking Number"
                               aria-label="Search" name="booking-number">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div><!-- Nav bar-->
</div>