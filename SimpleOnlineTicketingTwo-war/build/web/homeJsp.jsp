<%-- 
    Document   : homeJsp
    Created on : 2 févr. 2019, 08:28:20
    Author     : diberger
--%>
<%@page import="java.util.List"%>
<%@page import="metier.Event"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EventFlix</title>
    </head>
    <body>
        <h1>EventFlix</h1>
        <table>
            <thead>
                <tr>
                    <th>Catégorie</th>
                    <th>Nom de l'évènement</th>
                    <th>Description</th>
                    <th>Lieu</th>
                    <th>Prix</th>
                </tr>
            </thead>
            <jsp:useBean id="eventBean" class="beans.EventBean" scope="page"/>
                              
            <tbody>
                
                <c:forEach items="${events}" var="event">
                    <tr>
                        <td><c:out value="${event.category.name}"/></td>  
                        <td><c:out value="${event.name}"/></td> 
                        <td><c:out value="${event.description}"/></td> 
                        <td><c:out value="${event.price}"/></td> 
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%!            
            metier.Customer customer = new metier.Customer("Dimitri", "motdepasse", true);
        %>
        <%
            out.println("<h1>" +  customer.getLogin() + " adore les servlets" + "</h1>");
        %>
    </body>
</html>
