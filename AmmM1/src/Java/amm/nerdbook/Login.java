/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.UtenteFactory;
import amm.nerdbook.Classi.Utente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 *
 * @author Kevin
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        
        //l'utente non è autenticato quindi mostro il form di login
        if (request.getParameter("logout") != null) {
            session.invalidate();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if (session.getAttribute("loggedIn") != null
                && session.getAttribute("loggedIn").equals(true)) {
            //l'utente è loggato, effettuo un controllo sui dati immessi
            
            String username = request.getParameter("user");
            String password = request.getParameter("pasw");
            
            int userId= UtenteFactory.getInstance().getIdByUserAndPassword(username,password);
            
            Utente user= UtenteFactory.getInstance().getUtenteById(userId);
            
            if ( user.getNome().equals("") || user.getCognome().equals("") || user.getUrlFotoProfilo().equals("") || user.getFrase().equals(""))
            {
                //se  l’utente ha registrato nome, cognome, immagine del profilo e 
                //frase di presentazione in modo corretto viene visualizzata la bacheca
                //con i post dell'utente
                request.getRequestDispatcher("Bacheca").forward(request, response);
                return;
            } else {
                //invece se qualche dato è settato a null visualizzo la pagina di 
                //modifica dei dati del profilo
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
                return;
            }

            //Se l'utente non è loggato
        } else {
            String username = request.getParameter("user");
            String password = request.getParameter("pasw");

            int logUserID = -1;

            if (username != null && password != null) {
                logUserID = UtenteFactory.getInstance().getIdByUserAndPassword(username, password);
            }

            if (logUserID != -1) {
                //username e password corrispondono ad un determinato utente 
                //presente nella Factory 
                session.setAttribute("loggedIn", true);
                session.setAttribute("loggedUserID", logUserID);

                request.getRequestDispatcher("Bacheca").forward(request, response);
                return;
            } else {
                //l’utente ha inviato username e password errati
                request.setAttribute("datiNonValidi", true);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
        }
        
            request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
