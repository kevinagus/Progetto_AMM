/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

/**
 *
 * @author Kevin
 */
public class Post {
    
    public enum Type{
        TEXT,IMAGE,LINK;
    };
    
    protected int id;
    protected Utente owner;
    protected Utente autore;
    private String content;
    private String url;
    private Type postType;
    
    public Post(){
        id = 0;
        owner = null;
        autore=null;
        content = "";
        url="";
        postType = Type.TEXT;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public Utente getOwner() {
        return owner;
    }

    /**
     * @param user the user to set
     */
    public void setOwner(Utente user) {
        this.owner = user;
    }
    
      /**
     * @return the user
     */
    public Utente getAutore() {
        return autore;
    }

    /**
     * @param user the user to set
     */
    public void setAutore(Utente user) {
        this.autore = user;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
     /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }
}
