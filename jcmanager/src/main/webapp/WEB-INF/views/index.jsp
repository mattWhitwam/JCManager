<%-- 
    Document   : index
    Created on : 01 Nov 2014, 8:36:39 PM
    Author     : Matthew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JobCard Manager</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="resources/style.css">
    </head>
    <body>
        <%@include file="/resources/includes/headerbar.html" %>
        <%@include file="/WEB-INF/jspf/mainMenu.jspf" %>
        <div class="usableArea">
            <div>
                <p>Here's some stuff for trying it all out though:</p>
                <a href="./x">
                    Click here for X
                </a>
                <br />
                <a href="./y">
                    Click here for Y
                </a>
            </div>
            <div>${value}</div>
        </div>
    </body>
</html>
