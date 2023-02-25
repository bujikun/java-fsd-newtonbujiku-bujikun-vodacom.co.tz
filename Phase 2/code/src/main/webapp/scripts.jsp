<%--
  Created by IntelliJ IDEA.
  User: newtonbujiku
  Date: 2/23/23
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.js"></script>
<script src="js/base.js"></script>
<script src="js/percircle.js"></script>
<script src="js/popper.js"></script>
<script>
    $(document).ready(() => {
        const setNavManipulation = (id)=>{
            const navTitle = $(id);
            navTitle.css("color", "#198754");
            navTitle.hover(() => {
                navTitle.css("color", "white");
            }, () => {
                navTitle.css("color", "#198754");
            });
        };
        setNavManipulation("#home-button");
        setNavManipulation("#login-button");

        const setRoutes = (node)=>{
            node.click(()=>{
                window.location.href=node.attr("href");
            });
        }
        const  admBtn = $("#login-button");
        const  hmBtn = $("#home-button");
        setRoutes(admBtn);
        setRoutes(hmBtn);
    });
</script>
