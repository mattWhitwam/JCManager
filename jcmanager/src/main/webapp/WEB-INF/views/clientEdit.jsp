<%-- 
    Document   : clients
    Created on : 02 Nov 2014, 4:23:47 PM
    Author     : Matt
--%>

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
            <form id="clientEdit" action="edit" method="POST">
                Client ID: <input readonly type="text" name="clientId" value="${clientId}"/><br/>
                Client Name: <input type ="text" name="clientName" value="${clientName}"/><br/>
                <br/>
                <input type="submit" value="Save"/>
            </form>
        </div>
    </body>
</html>
