<%-- 
    Document   : nuovopost
    Created on : 11-mag-2017, 23.05.34
    Author     : Kevin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="newPost">
    
    <c:set var="user" value="${utente}" scope="request"/> 
    <c:set var="userLogged" value="${userLoggato}" scope="request"/>
    
    <c:if test="${conferma==true}">
        <p>Hai scritto sulla bacheca di ${utente.nome} ${utente.cognome}</p>
    </c:if>
    
    <c:if test="${nuovoPost==false and conferma!=true}">
        <form action="Bacheca?utente=${user.id}" method="post">
            
            <div id="divPost">
                <div>
                    <h2>Nuovo Post</h2>
                </div>
                <div class="postType">
                    <label for="postType">Post di Testo</label>
                    <input type="radio" name="postType" value="text" id="textType">
                </div>
                <div class="postType">
                    <label for="postType">Post con Foto</label>
                    <input type="radio" name="postType" value="img" id="imgType">
                </div>
                <div id="link" class="postType">
                    <label for="postType">Post con Link</label>
                    <input type="radio" name="postType" value="link" id="linkType">
                </div>
                <div id="postContent">
                    <div class="campiDati">
                        <label for="textPost">Testo:</label>
                        <textarea name="textPost" id="textPost"></textarea>
                    </div>
                    <div class="campiDati">
                        <label for="imgPost">URL immagine:</label>
                        <input type="file" name="imgPost" id="imgPost">
                    </div>
                    <div class="campiDati">
                        <label for="linkPost">URL link:</label>
                        <input type="text" name="linkPost" id="linkPost">
                    </div>
                    <button class="button" type="submit">Invia</button>
                </div>
            </div>
        </form>
    </c:if>
    
    <c:if test="${nuovoPost==true and conferma!=true}">
        <form action="Bacheca?utente=${user.id}&nuovopost=1" method="post">
            <div id="divPost">
                    <div>
                        <h2>Riepilogo nuovo post</h2>
                    </div>

                    <div id="postContent">    
                        <p>Autore post: ${userLogged.nome} ${userLogged.cognome}</p>    
                        <p>Proprietario bacheca: ${user.nome} ${user.cognome}</p>

                        <c:set var="post" value="${newPost}" scope="request"/>
                        <c:if test="${Testo==true}">
                            <p>Testo: ${post.content}</p>
                        </c:if>
                        <c:if test="${Immagine==true}">
                            <p>Immagine:</p>                       
                        </c:if>
                        <c:if test="${Link==true}">
                            <p>Link: ${post.content}</p>
                        </c:if>            
                    </div>
                    <button class="button" type="submit">Conferma Post</button>
            </div>
        </form>
    </c:if>
</div>