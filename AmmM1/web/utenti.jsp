<%-- 
    Document   : utenti
    Created on : 29-apr-2017, 21.46.42
    Author     : Kevin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="utenti">
    <h2>Utenti</h2>
    <ul>
        <c:forEach var="user" items="${users}">
            <li class="picutente"><a href="Bacheca?utente=${user.id}" >${user.nome} ${user.cognome}</a></li>
        </c:forEach>
    </ul>
</div>
