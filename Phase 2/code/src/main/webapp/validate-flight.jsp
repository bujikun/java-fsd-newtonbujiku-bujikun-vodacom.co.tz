<%--
  Created by IntelliJ IDEA.
  User: newtonbujiku
  Date: 3/1/23
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>

<script>
    const validateFlightForm = () => {
        let source = document.forms["validate-flight-form"]["source"].value;
        let destination = document.forms["validate-flight-form"]["destination"].value;
        if (source===destination) {
            $("#error").append(`<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <span>Source can not be the same as destination</span>
</div>`);
            window.setTimeout(()=>{
                $("#error").empty();
            },2500)
            return false;
        }
        return true;
    };
</script>