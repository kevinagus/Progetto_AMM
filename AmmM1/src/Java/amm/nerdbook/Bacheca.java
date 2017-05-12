/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Utente;
import amm.nerdbook.Classi.UtenteFactory;
import amm.nerdbook.Classi.Post;
import amm.nerdbook.Classi.PostFactory;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin
 */
public class Bacheca extends HttpServlet {

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
        
         //ricerco una sessione pre esistente, se questa non esite 
        //non viene creata una nuova e dentro session non vi è niente
        HttpSession session = request.getSession(false);
        
        if(session != null && session.getAttribute("loggedIn") != null &&
           session.getAttribute("loggedIn").equals(true))
        {
            //l’utente è autenticato..
            //controllo se è impostato il parametro get "user" che mi consente
            //di visualizzare la bacheca di uno specifico utente.
            String user = request.getParameter("utente");
            
            int userID = -1;

            if (user != null) {
                userID = Integer.parseInt(user);
            } else {
                Integer loggedUserID = (Integer) session.getAttribute("loggedUserID");
                userID = loggedUserID;
            }

            Utente utente = UtenteFactory.getInstance().getUtenteById(userID);
            ArrayList<Utente> listaUtenti = UtenteFactory.getInstance().getListaUtenti();
            
            if (utente != null) {
                request.setAttribute("utente", utente);
                request.setAttribute("users",listaUtenti);

                List<Post> posts = PostFactory.getInstance().getPostList(utente);
                request.setAttribute("posts", posts);

                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        else
        {
            //l'utente non è autenticato quindi rimando a bacheca.jsp
            //dove mostro un messaggio di accesso negato
            request.setAttribute("notAutenticate",true);
            request.getRequestDispatcher("bacheca.jsp").forward(request,response);
            return;
        }
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
