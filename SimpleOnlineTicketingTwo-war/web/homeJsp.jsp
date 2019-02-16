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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    
        <title>EventFlix</title>
    </head>
    <body>
        <h1>EventFlix</h1>
        <table class="table table-bordered table-striped">
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
                        <td><c:out value="${event.category.nom}"/></td>  
                        <td><a href="./?id=${event.id}"><c:out value="${event.name}"/></a></td> 
                        <td><c:out value="${event.description}"/></td> 
                        <td><c:out value="${event.place}"/></td> 
                        <td><c:out value="${event.price}"/></td> 
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <%!            
            metier.Customer customer = new metier.Customer("Dimitri", "motdepasse", true);
        %>
        <%
           
        %>
        <p>Tu es connecté en tant que : ${user}</p>
        <a href="./faces/addEventFormBean.xhtml">Ajouter un évenement</a>
        <a href="./faces/addCategoryFormBean.xhtml">Ajouter une categorie</a>
        <a href="./faces/login.xhtml">Se connecter</a>
        <a href="./faces/register.xhtml">S'inscrire</a>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
