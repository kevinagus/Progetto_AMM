<%-- 
    Document   : bacheca
    Created on : 26-apr-2017, 22.50.13
    Author     : Kevin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="it-IT">
    <head>
        <title>Bacheca</title>
        <meta charset="UTF-8">
        <meta name="author" content="Agus Kevin">
        <meta name="keywords" content="conosci,trova e chatta con i tuoi amici nerd">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/javascript.js"></script>
    </head>
    <body>
        
        <c:set var="titolo" value="Bacheca" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="nav.jsp"/>
             
        <c:if test="${not empty userLoggato }">
            <jsp:include page="utenti.jsp"/>
        </c:if>
        
        <c:if test="${notAutenticate==true}">
            <div id="notAutenticate">
                Utente non autenticato. Accesso negato.
            </div>
        </c:if>
        <c:if test="${displayGroup==true}">
            <jsp:include page="group_posts.jsp"/>
        </c:if>
        <c:if test="${notAutenticate!=true && displayGroup!=true}">
            <c:set var="user" value="${utente}" scope="request"/> 
            <div id="titoloBacheca">
                <h2>${user.nome} ${user.cognome}</h2>
                <img class="BachecaPic" alt="Foto profilo" src="${user.urlFotoProfilo}"> 
                <p>- ${user.frase} -</p>
            </div>          
            <div id="divPost">
                <c:if test="${amicizia==true}">
                    <c:if test="${userLoggato.id != utente.id}">
                        <p id="amici">Hai stretto amicizia con ${utente.nome} ${utente.cognome}</p>
                    </c:if>
                    <jsp:include page="nuovopost.jsp"/>
                </c:if>
                <c:if test="${amicizia!=true}">
                    <p id="amici">Non hai ancora stretto amicizia con ${utente.nome} ${utente.cognome}</p>
                </c:if>
                <c:forEach var="post" items="${posts}">
                    <div id="divPosts"> 
                        <h3>${post.autore.nome} ${post.autore.cognome}</h3>
                
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
             
        </c:if>

    </body>
</html>
