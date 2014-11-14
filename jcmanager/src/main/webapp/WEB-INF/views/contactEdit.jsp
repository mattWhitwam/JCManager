<%-- 
    Document   : siteEdit
    Created on : 05 Nov 2014, 2:41:57 PM
    Author     : Matt
--%>

<%@page import="za.co.dwarfsun.jcmanager.domain.ContactPerson"%>
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
        <%
            ContactPerson contact = (ContactPerson)request.getAttribute("contact");
        %>
        <div class="usableArea">
            <form class="editForm" action="/jcmanager/sites/saveContact" method="POST">
                <h2> Contact Details </h2>
                Client ID: <input readonly type="text" name="clientId" value="${clientId}"/><br/>
                Contact ID: <input readonly type="text" name="contactId" value="<% out.print(contact.getId()); %>"/><br/>
                Description: <input type ="text" name="contactDescription" value="<% out.print(contact.getDescription()); %>"/><br/>
                First Name: <br/>
                Last Name: <br/>
                <br/>
                <input type="submit" value="Save"/>
            </form>
        </div>
    </body>
</html>
