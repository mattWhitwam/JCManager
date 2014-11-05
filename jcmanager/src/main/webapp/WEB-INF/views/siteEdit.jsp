<%-- 
    Document   : siteEdit
    Created on : 05 Nov 2014, 2:41:57 PM
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
            <form class="editForm" action="/jcmanager/sites/saveSite" method="POST">
                <h2> Site Details </h2>
                Client ID: <input readonly type="text" name="clientId" value="${clientId}"/><br/>
                Site ID: <input readonly type="text" name="siteId" value="${siteId}"/><br/>
                Site Name: <input type ="text" name="siteName" value="${siteName}"/><br/>
                Site Address: <br/>
                <textarea name="siteAddress">${siteAddress}</textarea>
                <br/>
                <input type="submit" value="Save"/>
            </form>
        </div>
    </body>
</html>
