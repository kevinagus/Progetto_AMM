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

        <c:if test="${not empty loggedUserID }">
            <jsp:include page="utenti.jsp"/>
        </c:if>  

        <div id="iscriviti">

            <c:if test="${visualizeData==true}">
                <div id="datiInseriti">
                    <h2>Riepilogo dati inseriti</h2>
                    <div id="divNome">
                        <strong>Nome:</strong>
                        ${utente.nome}
                    </div>
                    <div id="divCognome">
                        <strong>Cognome:</strong>
                        ${utente.cognome}
                    </div>
                    <div id="divFoto">
                        <strong>URL foto profilo:</strong>
                        ${utente.urlFotoProfilo}
                    </div>
                    <div id="divFrase">
                        <strong>Frase di presentazione:</strong>
                        ${utente.frase}
                    </div>
                    <div id="divData">
                        <strong>Data di nascita:</strong>
                        ${utente.dataDiNascita}
                    </div>
                </c:if> 

                <c:if test="${notAutenticate==true}">
                    <div id="UserNonAutenticato">
                        Utente non autenticato. Accesso negato.
                    </div>
                </c:if>

                <c:if test="${notAutenticate!=true and visualizeData!=true}">

                    <div id="datiInseriti">
                        <h2>Riepilogo dati inseriti</h2>
                        <div id="divNome">
                            <strong>Nome: </strong>
                            ${userLoggato.nome}
                        </div>
                        <div id="divCognome">
                            <strong>Cognome: </strong>
                            ${userLoggato.cognome}
                        </div>
                        <div id="divFoto">
                            <strong>URL foto profilo: </strong>
                            ${userLoggato.urlFotoProfilo}
                        </div>
                        <div id="divFrase">
                            <strong>Frase di presentazione: </strong>
                            ${userLoggato.frase}
                        </div>
                        <div id="divData">
                            <strong>Data di nascita: </strong>
                            ${userLoggato.dataDiNascita}
                        </div>
                    </div>

                    <h2>Modifica dati:</h2>
                        
                    <form action="Profilo" method="post">
                        <div id="divNome">
                            <label for="user">Nome</label>
                            <input type="text" name="user" id="nome"/>
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
                            <label for="pawd">Password</label>
                            <input type="password" name="pawd" id="pswd"/>
                        </div>
                        <div id="divCpswd">
                            <label for="cpswd">Conferma password</label>
                            <input type="password" name="cpswd" id="cpswd"/>
                        </div>
                        <div id="divButton">
                            <button class="button" type="submit">Aggiorna</button>
                        </div>
                    </form>
                    <form action="Profilo?delete=1" method="post">
                        <div id="delButton">
                            <button class="deletebutton" type="submit">Elimina profilo</button>
                        </div>
                    </form>
                </c:if>  
            </div>
    </body>
</html>

