<%-- 
    Document   : nuovopost
    Created on : 11-mag-2017, 23.05.34
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="newPost">
    <form action="Bacheca" method="post">
        <div id="divPost">
            <div>
                <label for="textType">Scelta bacheca utente per pubblicare il post:</label>
                <ul>
                    <c:forEach var="utente" items="${users}">
                        <li class="users">
                            <label for="choosebacheca">${utente.nome} ${utente.cognome}</label>
                            <input type="radio" name="choosebacheca">
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="postType">
                <label for="textType">Post di Testo</label>
                <input type="radio" name="postType" value="textType" id="textType">
            </div>
            <div class="postType">
                <label for="imgType">Post con Foto</label>
                <input type="radio" name="postType" value="imgType" id="imgType">
            </div>
            <div class="postType">
                <label for="linkType">Post con Link</label>
                <input type="radio" name="postType" value="linkType" id="linkType">
            </div>
            <div id="postContent">
                <div>
                    <label for="textPost">Testo</label>
                    <textarea name="textPost" id="textPost"></textarea>
                </div>
                <div>
                    <label for="imgPost">URL immagine</label>
                    <input type="file" name="imgPost" id="imgPost">
                </div>
                <div>
                    <label for="linkPost">URL link</label>
                    <input type="text" name="linkPost" id="linkPost">
                </div>
            </div>
            <button type="submit">Invia</button>
        </div>
    </form>
</div>