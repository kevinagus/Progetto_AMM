<%-- 
    Document   : utenti
    Created on : 29-apr-2017, 21.46.42
    Author     : Kevin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="utenti">
    <%-- se l'utente si trova nella pagina Bacheca l'attributo search è true--%>
    <c:if test="${search==true}">
        <div id="searchUser">
            <input id="searchField" type="text" placeholder="Cerca amico.." value="">
            <button id="buttonSearch">Ricerca</button>
        </div>
    </c:if>
    
    <h2>Utenti</h2>
    <ul id="usersList">
        <c:forEach var="user" items="${users}">
            <li class="picutente"><a href="Bacheca?utente=${user.id}" >${user.nome} ${user.cognome}</a></li>
        </c:forEach>
    </ul>

    <h2>Gruppi</h2>
    <ul id="groupList">
        <c:forEach var="group" items="${groups}">
            <li class="picgroup"><a href="Bacheca?gruppo=${group.getId()}">${group.getNome()}</a></li>
        </c:forEach>
    </ul>
</div>


