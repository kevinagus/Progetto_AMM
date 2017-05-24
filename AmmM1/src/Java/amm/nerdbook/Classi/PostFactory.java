/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class PostFactory {
    
    private static PostFactory singleton;
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        /*
        UtenteFactory utenteFactory = UtenteFactory.getInstance();

        //Creazione Post
        Post post1 = new Post();
        post1.setContent("Sabato 29 aprile le autorità turche hanno bloccato l'accesso a tutte le versioni linguistiche di Wikipedia, ledendo il diritto di milioni di persone di accedere a informazioni storiche, culturali e scientifiche neutrali e munite di fonti verificabili.");
        post1.setId(0);
        post1.setUser(utenteFactory.getUtenteById(1));
        post1.setPostType(Post.Type.TEXT);

        Post post2 = new Post();
        post2.setContent("img/ferrari.jpg");
        post2.setId(1);
        post2.setUser(utenteFactory.getUtenteById(2));
        post2.setPostType(Post.Type.IMAGE);
        
        Post post3 = new Post();
        post3.setContent("Gli Articolo 31 sono stati un gruppo rap italiano, formatosi a Milano nel 1990 e composto da J-Ax e DJ Jad. Hanno avuto un successo notevole sia in Italia che all'estero, riproponendo in italiano, soprattutto negli anni novanta, i caratteri distintivi del loro genere di allora, come il freestyle e il campionamento di noti ritornelli. Nel 1994 hanno fondato la Spaghetti Funk e dagli anni duemila, subito dopo aver pubblicato Greatest Hits, hanno svoltato verso sonorità più pop assumendo un cantato più melodico e perdendo parzialmente le sonorità hip hop.");
        post3.setId(2);
        post3.setUser(utenteFactory.getUtenteById(2));
        post3.setPostType(Post.Type.TEXT);
        
        Post post4 = new Post();
        post4.setContent("www.google.com");
        post4.setId(3);
        post4.setUser(utenteFactory.getUtenteById(2));
        post4.setPostType(Post.Type.LINK);

        Post post5 = new Post();
        post5.setContent("www.intel.it");
        post5.setId(4);
        post5.setUser(utenteFactory.getUtenteById(3));
        post5.setPostType(Post.Type.LINK);

        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);

        */
    }

    public Post getPostById(int id) {
        UtenteFactory utenteFactory=UtenteFactory.getInstance();
        
        try{
            //connessione al DB
            Connection conn=DriverManager.getConnection(connectionString,"nerd","nerd");
            
            String query="select * from post " +
                         "join posttype on post.tipo=posttype.type_id "+
                         "where post_id=?";
            
            //Prepared Statement
            PreparedStatement stmt=conn.prepareStatement(query);
            
            //associamo i valori
            stmt.setInt(1,id);
            
            //esecuzione della query
            ResultSet res=stmt.executeQuery();
            
            //ciclo sul risultato dell'esecuzione della query
            if(res.next())
            {
                Post corrente=new Post();
                
                //imposto id al post
                corrente.setId(res.getInt("post_id"));
                
                //imposto l'autore del post
                Utente autore=UtenteFactory.getInstance().getUtenteById(res.getInt("autore"));
                corrente.setUser(autore);
                
                //imposto il tipo del post
                corrente.setPostType(this.postTypeFromString(res.getString("post_name")));
                
                //imposto il contenuto del post
                corrente.setContent(res.getString("content"));
                
                stmt.close();
                conn.close();
                return corrente;
            }
            
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        /*
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        */
        return null;
        
    }

    public List getPostList(Utente user) {
        
        List<Post> listaPost= new ArrayList<Post>();
        
        try{
            Connection conn= DriverManager.getConnection(connectionString, "nerd", "nerd");
            
            String query="select * from post "+
                         "join posttype on post.tipo=posttype.type_id "+
                         "where autore=?";
            
            //Prepared Statement
            PreparedStatement stmt=conn.prepareStatement(query);
            
            //Associazioni valori
            stmt.setInt(1,user.getId());
            
            //Esecuzione query
            ResultSet res=stmt.executeQuery();
            
            //ciclo sulle righe restituite
            while(res.next())
            {
                Post corrente=new Post();
                
                //imposto id del post
                corrente.setId(res.getInt("post_id"));
                
                //imposto l'autore del post
                corrente.setUser(user);
                
                //imposto il tipo del post
                corrente.setPostType(this.postTypeFromString(res.getString("post_name")));
                
                //imposto il contenuto del post
                corrente.setContent(res.getString("content"));
            
                listaPost.add(corrente);
            }
            
            stmt.close();
            conn.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return listaPost;
        /*
        List<Post> listaPst = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(user)) {
                listaPst.add(post);
            }
        }
        
        return listaPst;
        */
    }
    
    public void addNewPost(Post post){
        try{
            Connection conn= DriverManager.getConnection(connectionString,"nerd","nerd");
            
            String query="insert into post (post_id,autore,tipo,content) "+
                         "values (default, ? , ? , ? )";
            
            PreparedStatement stmt=conn.prepareStatement(query);
            
            //associazione valori
            stmt.setInt(1,post.getUser().getId());
            
            stmt.setInt(2,this.postTypeFromEnum(post.getPostType()));
            
            stmt.setString(3,post.getContent());
            
            //esecuzione della query
            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deletePosts(Utente user){
        try{
            Connection conn= DriverManager.getConnection(connectionString,"nerd","nerd");
            
            String query="delete from post where autore=?";
            
            PreparedStatement stmt=conn.prepareStatement(query);
            
            //associazione valori
            stmt.setInt(1,user.getId());
            
            //esecuzione della query
            stmt.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
            
    
    private Post.Type postTypeFromString(String type){
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        else if(type.equals("LINK")){
            return Post.Type.LINK;
        }
        else{
            return Post.Type.TEXT;
        }
    }
    
    private int postTypeFromEnum(Post.Type type){
        
        if(type==Post.Type.TEXT){
            return 1;
        }
        else if(type==Post.Type.IMAGE){
            return 2;
        }
        else
            return 3;
    }
}