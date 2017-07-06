<%-- 
    Document   : group_posts
    Created on : 4-lug-2017, 15.43.12
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="divPost">
    <h2>${group.nome}</h2>
    <c:forEach var="post" items="${posts}">
        <div id="divPosts">
            <h3>${post.getAutore().getNome()} ${post.getAutore().getCognome()}</h3>

            <p>${post.content}</p>

            <c:if test="${post.postType == 'LINK'}">
                <a href="${post.url}">${post.url}</a>
            </c:if>
            <c:if test="${post.postType == 'IMAGE'}">
                <img class="ProfPic" alt="Foto del post" src="${post.url}"> 
            </c:if>
        </div>
    </c:forEach>
</div>