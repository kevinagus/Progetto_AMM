<%-- 
    Document   : nav
    Created on : 26-apr-2017, 22.35.32
    Author     : Kevin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav>
    <ul>
        <li <c:if test="${page=='bacheca'}">class="active"</c:if>
            <c:if test="${page!='bacheca'}">class="other"</c:if> >
            <a href="bacheca.html">Bacheca</a>
        </li>
        <li <c:if test="${page=='descrizione'}">class="active"</c:if>
            <c:if test="${page!='descrizione'}">class="other"</c:if> >
            <a href="descrizione.html">Informazioni</a>
        </li>
        <li <c:if test="${page=='login'}">class="active"</c:if>
            <c:if test="${page!='login'}">class="other"</c:if> >
            <a href="login.html">Login</a>
        </li>
        <li <c:if test="${page=='profilo'}">class="active"</c:if>
            <c:if test="${page!='profilo'}">class="other"</c:if> >
            <a href="profilo.html">Profilo</a>
        </li>
    </ul>
</nav>
