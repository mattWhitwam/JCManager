<%-- 
    Document   : clients
    Created on : 02 Nov 2014, 4:23:47 PM
    Author     : Matt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="za.co.dwarfsun.jcmanager.domain.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JobCard Manager</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/jcmanager/resources/style.css">
    </head>
    <body>
        <%@include file="/resources/includes/headerbar.html" %>
        <%@include file="/WEB-INF/jspf/mainMenu.jspf" %>
        <div class="usableArea">
            You have ${numClients} clients.
            ${clientsAsHTML}
        </div>
    </body>
</html>
