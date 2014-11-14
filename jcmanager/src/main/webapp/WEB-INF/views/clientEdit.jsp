<%-- 
    Document   : clients
    Created on : 02 Nov 2014, 4:23:47 PM
    Author     : Matt
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="za.co.dwarfsun.jcmanager.domain.Client"%>
<%@page import="za.co.dwarfsun.jcmanager.domain.Site"%>
<%@page import="za.co.dwarfsun.jcmanager.domain.ContactPerson"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            Client client = (Client)request.getAttribute("client");
        %>
        <div class="usableArea">
            <h2> Client Details </h2>
            <form class="editForm" action="edit" method="POST">
                Client ID: <input readonly type="text" name="clientId" value="<% out.print(client.getId()); %>"/><br/>
                Client Name: <input type ="text" name="clientName" value="<% out.print(client.getName()); %>"/><br/>
                <br/>
                <input type="submit" value="Save"/>
            </form>
                
            <h2> Client Sites </h2>
            <form  action="/jcmanager/sites/details" method="POST">
            <% 
                if (client != null) { 
            %>
                    <input type="hidden" name="clientId" value="<% out.print(client.getId()); %>"/> 
                    <input type="submit" value="Add New"/>
            <%
                }
            %>
            </form>
            <%
                if (client.getSites()!=null) {
                    for (Site s : client.getSites()) {
            %>
            <form action="/jcmanager/sites/details" method="POST" class="listed">
                <input type="hidden" name="clientId" value="<% out.print(client.getId()); %>"/>
                <input type="hidden" name="siteId" value="<% out.print(s.getId()); %>"/>
                <input readonly type="text" name="siteName" value="<% out.print(s.getName()); %>"/>
                <input type="submit" value="Manage"/>
            </form>
            <%
                    }
                } else {
                    out.println("No records to display...");
                }
            %>
            <h2> Client Contacts </h2>
            <form  action="/jcmanager/contacts/details" method="POST">
            <% 
                if (client != null) { 
            %>
                    <input type="hidden" name="clientId" value="<% out.print(client.getId()); %>"/> 
                    <input type="submit" value="Add New"/>
            <%
                }
            %>
            </form>
            <%
                if (client.getContactPersons()!=null) {
                    for (ContactPerson p : client.getContactPersons()) {
            %>
            <form action="/jcmanager/contacts/details" method="POST" class="listed">
                <input type="hidden" name="clientId" value="<% out.print(client.getId()); %>"/>
                <input type="hidden" name="contactId" value="<% out.print(p.getId()); %>"/>
                <input readonly type="text" name="contactDescription" value="<% out.print(p.getDescription()); %>"/>
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
