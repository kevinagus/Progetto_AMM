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
public class Utente {
    
    private int id;
    private String nome;
    private String cognome;
    private String urlFotoProfilo;
    private String frase;
    private String password;
    private String dataDiNascita;
    
    
    
    public Utente(){
        id=0;
        nome="";
        cognome="";
        urlFotoProfilo="";
        frase="";
        password="";
        dataDiNascita="";
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
     * @return the name
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the name to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return the surname
     */
    public String getCognome() {
        return cognome;
    }
    
    /**
     * @param cognome the surname to set
     */
    public void setCognome(String cognome) {
        this.cognome=cognome;
    }
    
    /**
     * @return the phrase
     */
    public String getFrase() {
        return frase;
    }
    
    /**
     * @param frase the phrase to set
     */
    public void setFrase(String frase) {
        this.frase = frase;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setDataDiNascita(String data){
        this.dataDiNascita=data;
    }
    
    public String getDataDiNascita(){
        return this.dataDiNascita;
    }
    
    @Override
    public boolean equals(Object altroUtente) {
        if (altroUtente instanceof Utente)
            if (this.getId() == ((Utente)altroUtente).getId()) return true;
        return false;
    }

    
}
