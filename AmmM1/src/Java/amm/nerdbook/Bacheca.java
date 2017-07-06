/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.Classi.Utente;
import amm.nerdbook.Classi.UtenteFactory;
import amm.nerdbook.Classi.Gruppo;
import amm.nerdbook.Classi.GruppoFactory;
import amm.nerdbook.Classi.Post;
import amm.nerdbook.Classi.PostFactory;
import java.io.IOException;
import java.util.*;
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

        if (session != null && session.getAttribute("loggedIn") != null
                && session.getAttribute("loggedIn").equals(true)) {
            int userID = -1;
            int groupID = -1;
            //attraverso l'id dell'utente attualmente loggato recupero le sue info
            //e setto l'attributo 'userLoggato'
            Integer loggedUserID = (Integer) session.getAttribute("loggedUserID");
            userID = loggedUserID;
            Utente userLoggato = UtenteFactory.getInstance().getUtenteById(userID);
            request.setAttribute("userLoggato", userLoggato);

            //l’utente è autenticato..
            //controllo se è impostato il parametro get "user" che mi consente
            //di visualizzare la bacheca di uno specifico utente.
            String user = request.getParameter("utente");
            String group= request.getParameter("gruppo");
            
            if (user != null) {
                userID = Integer.parseInt(user);
            }
            else if(group!=null){
                groupID= Integer.parseInt(group); 
                request.setAttribute("displayGroup",true);
            }
            
            Gruppo grp = GruppoFactory.getInstance().getGruppoById(groupID);             
            Utente utente = UtenteFactory.getInstance().getUtenteById(userID);
            List<Utente> listaUtenti = UtenteFactory.getInstance().getListaUtenti();
            List<Gruppo> listaGruppi = GruppoFactory.getInstance().getListaGruppi(); 

            request.setAttribute("users", listaUtenti);
            request.setAttribute("groups",listaGruppi);
            request.setAttribute("search",true);
            
            if(grp!=null){
                List<Post> posts = PostFactory.getInstance().getPostList(grp);
                request.setAttribute("group",grp);
                request.setAttribute("posts", posts);
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
                return;
            }
            
            if (utente != null) {

                request.setAttribute("utente", utente);

                List<Post> posts = PostFactory.getInstance().getPostList(utente);
                request.setAttribute("posts", posts);
                
                //controllo se l'utente loggato al momento è amico con l'utente di cui
                //si sta visualizzando la bacheca a condizione che i due utenti siano 
                //distinti e non uguali
                
                if(! utente.equals(userLoggato)){
                    if(UtenteFactory.getInstance().controlloAmicizia(userLoggato,utente)){
                        request.setAttribute("amicizia",true);
                    }
                    else{
                        request.setAttribute("amicizia",false);
                    }                
                }
                else{
                    request.setAttribute("amicizia",true);
                }
                
                //controllo la presenza di un nuovo post che andrà quindi
                //confermato dall'utente prima di salvarlo nel DB
                String nPost = request.getParameter("nuovopost");
                if (nPost != null) {
                    //il nuovo post è stato confermato dall'utente
                    int checkPost = Integer.parseInt(nPost);
                    if (checkPost == 1) {
                        request.setAttribute("conferma", true);
                    }
                }

                //controllo se l'utente ha specificato il tipo del nuovo post
                String postType = request.getParameter("postType");
                if (postType != null) {
                    Post newPost = new Post();
                    //imposto l'autore al nuovo post
                    newPost.setAutore(userLoggato);
                    //imposto il proprietario del nuovo post
                    newPost.setOwner(utente);
                    //imposto il contenuto del post presente in tutte le tipologie
                    newPost.setContent(request.getParameter("textPost"));
                    
                    if (postType.equals("text")) {
                        newPost.setPostType(Post.Type.TEXT);
                        request.setAttribute("Testo", true);
                    }
                    else if (postType.equals("img")) {
                        newPost.setPostType(Post.Type.IMAGE);
                        newPost.setUrl(request.getParameter("imgPost"));
                        request.setAttribute("Immagine", true);
                    }
                    else{
                        newPost.setPostType(Post.Type.LINK);
                        newPost.setUrl(request.getParameter("linkPost"));
                        request.setAttribute("Link", true);
                    }
                    //aggiungo il nuovo post al DB attraverso il metodo addNewPost
                    PostFactory.getInstance().addNewPost(newPost);
                    request.setAttribute("nuovoPost", true);
                    request.setAttribute("newPost", newPost);
                        
                } 
                else {
                    //nel caso l'utente non abbia specificato il tipo di un nuovo post
                    request.setAttribute("nuovoPost", false);
                }
       
                request.getRequestDispatcher("bacheca.jsp").forward(request, response);
            }else{
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
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
