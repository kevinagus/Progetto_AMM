/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.PostFactory;
import amm.nerdbook.Classi.UtenteFactory;
import amm.nerdbook.Classi.Utente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 *
 * @author Kevin
 */
@WebServlet(loadOnStartup = 0)
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH="../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH="WEB-INF/db/ammdb";
    
    @Override
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try{
            Class.forName(JDBC_DRIVER);
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //IMPOSTO LA CONNECTION STRING PER OGNI FACTORY
        UtenteFactory.getInstance().setConnectionString(dbConnection);
        PostFactory.getInstance().setConnectionString(dbConnection);
    }
    
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
            
            //in questo punto un utente loggato puo tentare di accedere nuovamente alla pagina login

            //l'utente è loggato, effettuo un controllo sui dati immessi

            String username = request.getParameter("user");
            String password = request.getParameter("pasw");
            
            //ricontrolla questo if
            if(username==null)
            {
                request.getRequestDispatcher("Profilo").forward(request, response);
                return;
            }
            
            int userId = UtenteFactory.getInstance().getIdByUserAndPassword(username, password);

            Utente user = UtenteFactory.getInstance().getUtenteById(userId);
            
            ArrayList<Utente> listaUtenti = UtenteFactory.getInstance().getListaUtenti();
            request.setAttribute("users",listaUtenti); 

            if (user.getNome().equals("") || user.getCognome().equals("") || user.getUrlFotoProfilo().equals("") || user.getFrase().equals("")) {
                //invece se qualche dato è settato a null visualizzo la pagina di 
                //modifica dei dati del profilo
                request.getRequestDispatcher("profilo.jsp").forward(request, response);
                return;
            } else {

                //se  l’utente ha registrato nome, cognome, immagine del profilo e 
                //frase di presentazione in modo corretto viene visualizzata la bacheca
                //con i post dell'utente
                request.getRequestDispatcher("Bacheca").forward(request, response);
                return;
            }

            //Se l'utente non è loggato
        } else {
            String username = request.getParameter("user");
            String password = request.getParameter("pasw");

            int logUserID = -1;

            if (username != null && password != null) 
            {
                logUserID = UtenteFactory.getInstance().getIdByUserAndPassword(username, password);

                if (logUserID != -1) {
                    //username e password corrispondono ad un determinato utente 
                    //presente nella Factory 
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", logUserID);

                    Utente user = UtenteFactory.getInstance().getUtenteById(logUserID);
                    
                    ArrayList<Utente> listaUtenti = UtenteFactory.getInstance().getListaUtenti();
                    request.setAttribute("users",listaUtenti); 

                    if (user.getNome().equals("") || user.getCognome().equals("") || user.getUrlFotoProfilo().equals("") || user.getFrase().equals("")) {
                        //se qualche dato è settato a null visualizzo la pagina di 
                        //modifica dei dati del profilo
                        request.getRequestDispatcher("profilo.jsp").forward(request, response);
                        return;
                    } else {

                        //se  l’utente ha registrato nome, cognome, immagine del profilo e 
                        //frase di presentazione in modo corretto viene visualizzata la bacheca
                        //con i post dell'utente
                        request.getRequestDispatcher("Bacheca").forward(request, response);
                        return;
                    }
                } else {
                    //l’utente ha inviato username e password errati
                    request.setAttribute("datiNonValidi", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
            }
        }
        /*
            Se non si verifica nessuno degli altri casi, 
            tentativo di accesso diretto alla servlet Login -> reindirizzo verso 
            il form di login.
         */
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
