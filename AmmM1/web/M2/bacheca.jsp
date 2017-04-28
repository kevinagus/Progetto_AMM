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
    </head>
    <body>
        
        <c:set var="titolo" value="Bacheca" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="nav.jsp"/>
        
        <div class="pannello" id="utenti">
            <h2>Utenti</h2>
            <ul>
                <li><a href="#rana" class="picutente">Giovanni Rana</a></li>
                <li><a href="#vettel" class="picutente">Sebastian Vettel</a></li>
                <li><a href="#maioli" class="picutente">Claudio Maioli</a></li>
            </ul>
        </div>
        
        <div id="divPost">
            <h3>${user.nome}</h3>
            <c:forEach var="post" items="${posts}">
                <div>
                    <c:if test="${post.postType == 'TEXT'}">
                        <p>${post.content}</p>
                    </c:if>
                    <c:if test="${post.postType == 'LINK'}">
                        <p>${post.content}</p>
                    </c:if>
                    <c:if test="${post.postType == 'IMAGE'}">
                        <img alt="Foto del post" src="${post.img}"> 
                    </c:if>
                </div>
            </c:forEach>  
                
            <div id="divPost1">
                <a id="rana"></a>
                <h3>Giovanni Rana</h3>
                <img class="ProfPic" title="profilo" alt="foto di Giovanni Rana" src="img/rana.jpg" width="350" height="250">
                <p>Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
            
            <div id="divPost2">
                <a id="vettel"></a>
                <h3>Sebastian Vettel</h3>
                <img class="ProfPic" title="profilo2" alt="foto di Sebastian Vettel" src="img/vettel.jpg" width="350" height="250">
                <p>Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                <img class="ProfPic" title="ferrari" alt="SF17-JB" src="img/ferrari.jpg" width="350" height="250">
            </div>
            
            <div id="divPost3">
                <a id="maioli"></a>
                <h3>Claudio Maioli</h3>
                <img class="ProfPic" title="profilo3" alt="foto di Claudio Maioli" src="img/maioli.jpg" width="350" height="250">
                <p>Visitate la pagina di <a href="http://www.ligabue.com/" target="_blank">'Ligabue'</a></p>
            </div>        
        </div>
    </body>
</html>
