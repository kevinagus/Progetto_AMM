<%-- 
    Document   : listaUtentiJson
    Created on : 5-giu-2017, 15.01.39
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:array>
    <c:forEach var="user" items="${users}">
        <json:object>
            <json:property name="nome" value="${user.nome}"/>
            <json:property name="cognome" value="${user.cognome}"/>
            <json:property name="id" value="${user.id}"/>
        </json:object>
    </c:forEach>
</json:array>
