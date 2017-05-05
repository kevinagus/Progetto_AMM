<%-- 
    Document   : profilo
    Created on : 29-apr-2017, 22.56.26
    Author     : Kevin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="it-IT">
    <head>
        <title>Profilo</title>
        <meta charset="UTF-8">
        <meta name="author" content="Agus Kevin">
        <meta name="keywords" content="conosci,trova e chatta con i tuoi amici nerd">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        
        <c:set var="titolo" value="Profilo" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <c:set var="page" value="profilo" scope="request"/>
        <jsp:include page="nav.jsp"/>
        
        <jsp:include page="utenti.jsp"/>
        
        <div id="scritta">
            <h2>Iscriviti per vedere i post dei tuoi amici</h2>
        </div>
        <div id="iscriviti">
            <c:if test="${notAutenticate==true}">
                <div id="UserNonAutenticato">
                    Utente non autenticato. Accesso negato.
                </div>
            </c:if>
            <c:if test="${notAutenticate!=true}">
                <form action="Profilo" method="post">
                    <div id="divNome">
                        <label for="nome">Nome</label>
                        <input type="text" name="nome" id="nome"/>
                    </div>
                    <div id="divCognome">
                        <label for="cognome">Cognome</label>
                        <input type="text" name="cognome" id="cognome"/>
                    </div>
                    <div id="divFoto">
                        <label for="url">URL foto profilo</label>
                        <input type="text" name="url" id="url"/>
                    </div>
                    <div id="divFrase">
                        <label for="frase">Frase di presentazione</label>
                        <textarea rows="4" cols="20" name="frase" id="frase"></textarea>
                    </div>
                    <div id="divData">
                        <label for="data">Data di nascita</label>
                        <input type="date" name="data" id="data"/>
                    </div>
                    <div id="divPswd">
                        <label for="pswd">Password</label>
                        <input type="password" name="pswd" id="pswd"/>
                    </div>
                    <div id="divCpswd">
                        <label for="cpswd">Conferma password</label>
                        <input type="password" name="cpswd" id="cpswd"/>
                    </div>
                    <div id="divButton">
                        <button class="button" type="submit">Aggiorna</button>
                    </div>
                </form>
            </c:if>  
            <c:if test="${visualizeData==true}">
                <div id="datiInseriti">
                    <div id="divNome">
                        <strong>Nome:</strong>
                        ${nome}
                    </div>
                    <div id="divCognome">
                        <strong>Cognome:</strong>
                        ${cognome}
                    </div>
                    <div id="divFoto">
                        <strong>URL foto profilo:</strong>
                        ${url}
                    </div>
                    <div id="divFrase">
                        <strong>Frase di presentazione:</strong>
                        ${frase}
                    </div>
                    <div id="divData">
                        <strong>Data di nascita:</strong>
                        ${data}
                    </div>
                </form>
            </c:if> 
        </div>
    </body>
</html>

