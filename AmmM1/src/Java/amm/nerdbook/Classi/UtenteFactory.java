/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class UtenteFactory {

    private static UtenteFactory singleton;
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB


    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    private UtenteFactory() {
    }

    public Utente getUtenteById(int id) {
    
        try{
            Connection conn=DriverManager.getConnection(connectionString,"nerd","nerd");
            
            String query="select * from utente "+"where id=?";
            
            //Prepared Statement
            PreparedStatement stmt=conn.prepareStatement(query);
        
            //associo i valori alla query precedente
            stmt.setInt(1,id);
            
            //esecuzione della query
            ResultSet res=stmt.executeQuery();
            
            //col metodo next() di res ciclo le righe restituite dall'esecuzione
            if(res.next()){
                Utente corrente=new Utente();
                corrente.setId(res.getInt("id"));
                corrente.setNome(res.getString("nome"));
                corrente.setCognome(res.getString("cognome"));
                corrente.setUrlFotoProfilo(res.getString("urlfoto"));
                corrente.setFrase(res.getString("frase"));
                corrente.setPassword(res.getString("password"));
                corrente.setDataDiNascita(res.getDate("nascita").toString());
                
                stmt.close();
                conn.close();
                return corrente;
            }
            
            stmt.close();
            conn.close();
        }   
        catch(SQLException e){
            e.printStackTrace();
        }
        
        /*
        for (Utente user : this.listaUtenti) {
            if (user.getId() == id) {
                return user;
            }
        }*/
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password) {
        
        try{
            //percorso, username, password
            Connection conn=DriverManager.getConnection(connectionString, "nerd" , "nerd" );
            
            String query="select id from utente "+
                         "where nome=? and password=?";
            
            //Prepared Statement
            PreparedStatement stmt=conn.prepareStatement(query);
            
            //associo i valori ai ? all'interno della query
            stmt.setString(1,user);
            stmt.setString(2,password);
            
            //Esecuzione query
            ResultSet res=stmt.executeQuery();
            
            //ciclo sulle righe restituite salvate nella res
            if(res.next()){
                int id=res.getInt("id");
                
                stmt.close();
                conn.close();
                return id;
            }
            
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        /*for (Utente copiaUtente : this.listaUtenti) {
            if (copiaUtente.getNome().equals(user) && copiaUtente.getPassword().equals(password)) {
                return copiaUtente.getId();
            }
        }*/
        return -1;
    }
    
    public ArrayList<Utente> getListaUtenti(){
        ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
        
        try{
            //connessione al DB
            Connection conn= DriverManager.getConnection(connectionString,"nerd","nerd");
            
            String query="select * from utente";
            
            //Prepared Statemente
            PreparedStatement stmt=conn.prepareStatement(query);
            
            //eseguo la query
            ResultSet res=stmt.executeQuery();
            
            //ciclo sulle righe restituite
            while(res.next()){
                Utente corrente=new Utente();
                
                //imposto id dell'utente
                corrente.setId(res.getInt("id"));
                
                //imposto il nome dell'utente
                corrente.setNome(res.getString("nome"));
                
                //imposto il cognome dell'utente
                corrente.setCognome(res.getString("cognome"));
                
                //imposto l'url foto profilo
                corrente.setUrlFotoProfilo(res.getString("urlfoto"));
                
                //imposto la frase dell'utente
                corrente.setFrase(res.getString("frase"));
                
                //imposto la password dell'utente
                corrente.setPassword(res.getString("password"));
                
                //imposta la data di nascita
                corrente.setDataDiNascita(res.getDate("nascita").toString());
                
                //aggiungo l'utente alla lista
                listaUtenti.add(corrente);
            }
            
            stmt.close();
            conn.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        //ritorno la lista degli utenti
        return listaUtenti;

    }
    
    public void deleteUtente(Utente user)
    {
        if(user!=null){
            try{
                Connection conn= DriverManager.getConnection(connectionString,"nerd","nerd");

                String query="delete from utente "+
                                "where id=? and nome=?";
                
                PreparedStatement stmt=conn.prepareStatement(query);

                stmt.setInt(1, user.getId());
                stmt.setString(2, user.getNome());
                
                int res=stmt.executeUpdate();
                
                stmt.close();
                conn.close();
                       
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void updateUtente(Utente user)
    {
        if(user!=null)
        {
            try {
                Connection conn = DriverManager.getConnection(connectionString, "nerd", "nerd");
                
                String query =  "update utente set nome=? ,cognome=? "+
                                ",urlfoto=? ,frase=? ,nascita=? "+
                                "where id=? and password=?";
                
                PreparedStatement stmt = conn.prepareStatement(query);
                
                Date data=Date.valueOf(user.getDataDiNascita());
                
                stmt.setString(1,user.getNome());
                stmt.setString(2,user.getCognome());
                stmt.setString(3,user.getUrlFotoProfilo());
                stmt.setString(4,user.getFrase());
                stmt.setDate(5,data);
                stmt.setInt(6,user.getId());
                stmt.setString(7,user.getPassword());
                
                int res=stmt.executeUpdate();
                
                stmt.close();
                conn.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
