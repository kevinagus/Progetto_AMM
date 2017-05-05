<%-- 
    Document   : login
    Created on : 29-apr-2017, 23.09.04
    Author     : Kevin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="it-IT">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="author" content="Agus Kevin">
        <meta name="keywords" content="conosci,trova e chatta con i tuoi amici nerd">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        
        <c:set var="titolo" value="Login" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="page" value="login" scope="request"/>
        <jsp:include page="nav.jsp"/>
        
        <div id="divAccesso">
            
            <c:if test="${datiNonValidi == true}">
                <div id="WarningdatiNonValidi">I dati inseriti non sono corretti</div>
            </c:if>
                    
            <form action="Login" method="post">
                <div id="divUser">
                    <label class="ilogin" for="user">Username</label>
                    <input type="text" name="user" id="user"/>
                </div>
                <div id="divPswd">
                    <label class="ilogin" for="pasw">Password</label>
                    <input type="password" name="pasw" id="pasw"/>
                </div>
                <div id="divButton">
                    <button class="button" type="submit">ACCEDI</button>
                </div>
            </form>
        </div>
    </body>
</html>