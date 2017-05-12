/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class PostFactory {
    
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        
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
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostList(Utente user) {

        List<Post> listaPst = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(user)) {
                listaPst.add(post);
            }
        }
        return listaPst;
    }
}