<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/outlined.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/base.css">
    <link rel="preload" href="font/source-code-pro/SourceCodePro-ExtraLight.ttf"  as="font" type="font/ttf"
          crossorigin="anonymous">
    <link rel="icon" href="favicon.ico">
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
    <h1><%= "Hello World!" %>
    </h1>
    <br/>
    <span class="material-icons-outlined">face</span>
    <a href="hello-servlet">Hello Servlet</a>
</div>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>