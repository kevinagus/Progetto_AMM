<%-- 
    Document   : utenti
    Created on : 29-apr-2017, 21.46.42
    Author     : Kevin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="pannello" id="utenti">
    <h2>Utenti</h2>
    <ul>
        <c:forEach var="utente" items="${users}">
            <li><a href="bacheca.html#${utente.id}" class="picutente">${utente.nome}</a></li>
        </c:forEach>
    </ul>
</div>
