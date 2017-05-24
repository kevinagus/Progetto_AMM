/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Utente;
import amm.nerdbook.Classi.UtenteFactory;
import amm.nerdbook.Classi.PostFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin
 */
public class Profilo extends HttpServlet {

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
        
        ArrayList<Utente> listaUtenti = UtenteFactory.getInstance().getListaUtenti();
        request.setAttribute("users",listaUtenti); 
        
        if(session.getAttribute("loggedIn") != null &&
           session.getAttribute("loggedIn").equals(true))
        {     
             int userID = -1;
            //attraverso l'id dell'utente attualmente loggato recupero le sue info
            //e setto l'attributo 'userLoggato'
            Integer loggedUserID = (Integer) session.getAttribute("loggedUserID");
            userID = loggedUserID;
            Utente user = UtenteFactory.getInstance().getUtenteById(userID);
            session.setAttribute("userLoggato", user);
            
            
            String delete=request.getParameter("delete");
            int del=-1;
            if(delete!=null)
            {
                del=Integer.parseInt(delete);
            }
            
            if(del==1){          
                //cancello i post dell'utente presenti sulla bacheca
                PostFactory.getInstance().deletePosts(user);
                //cancello l'utente dal DB
                UtenteFactory.getInstance().deleteUtente(user);
                //imposto a null una serie di attributi propri dell'utente loggato
                session.setAttribute("loggedIn",null);
                session.setAttribute("userLoggato", null);
                session.setAttribute("loggedUserID",-1);
                
                //reindirizzo alla pagina di login
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
            
            String username =request.getParameter("user");
            String password =request.getParameter("pawd");
            String cognome =request.getParameter("cognome");
            String url =request.getParameter("url");
            String frase =request.getParameter("frase");
            
            if(username==null && password==null)
            {
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
                return;
            }
            
            //int userId = UtenteFactory.getInstance().getIdByUserAndPassword(username, password);
            //Utente user = UtenteFactory.getInstance().getUtenteById(userId);
            
            user.setNome(username);
            user.setCognome(cognome);
            user.setUrlFotoProfilo(url);
            user.setFrase(frase);
            
            //l'utente è autenticato ed ha inserito i dati del suo profilo,quindi li visualizzo 
            if(user.getNome().equals("") || user.getCognome().equals("") || 
                user.getUrlFotoProfilo().equals("") || user.getFrase().equals("") ) 
            {
                //l'utente ha scordato di inserire qualche dato, mostra il form per l'inserimento dei dati del profilo
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
                return;
            } else {
                //l’utente è autenticato, mostra i dati inseriti dopo l'aggiornamento
                session.setAttribute("visualizeData", true);
                
                request.setAttribute("utente", user);
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
                return;
            }
            
        }
        else
        {
            //l'utente non è autenticato quindi rimando a profilo.jsp
            //dove mostro un messaggio di accesso negato
            request.setAttribute("notAutenticate",true);
            request.getRequestDispatcher("profilo.jsp").forward(request,response);
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
