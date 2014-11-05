<%-- 
    Document   : clients
    Created on : 02 Nov 2014, 4:23:47 PM
    Author     : Matt
--%>

<%@page import="java.util.List"%>
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
            <h2>Clients</h2>

            <%
                List<Client> clients = (List<Client>)request.getAttribute("clients");
                if (clients!=null) {
                    //out.println(clients.size());
                    for (Client c : clients) {
                        %>            
            <form action="/jcmanager/clients/edit" method="POST" class="listed">
                <input readonly type="text" name="clientId" value="<% out.print(c.getId()); %>"/>
                <input readonly type="text" name="clientName" value="<% out.print(c.getName()); %>"/>
                <input type="submit" value="Manage"/> 
            </form>
                        <%
                    }
                } else {
                    out.println("No records to display...");
                }
            %>
        </div>
    </body>
</html>
