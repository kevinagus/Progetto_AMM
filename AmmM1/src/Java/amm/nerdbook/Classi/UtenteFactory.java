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
        /*
        Utente user1 = new Utente();
        user1.setId(1);
        user1.setNome("Lorenzo");
        user1.setCognome("Rossi");
        user1.setPassword("ciao");
        user1.setUrlFotoProfilo("");
        user1.setFrase("Felice d'esser qui.");
        
        
        Utente user2 = new Utente();
        user2.setId(2);
        user2.setNome("Guido");
        user2.setCognome("Frau");
        user2.setPassword("ehitu");
        user2.setUrlFotoProfilo("img/maioli.jpg");
        user2.setFrase("Fantastico.");

        Utente user3 = new Utente();
        user3.setId(3);
        user3.setNome("Fernando");
        user3.setCognome("Firinu");
        user3.setPassword("tavolo");
        user3.setUrlFotoProfilo("img/rana.jpg");
        user3.setFrase("Meraviglioso.");
        
        listaUtenti.add(user1);
        listaUtenti.add(user2);
        listaUtenti.add(user3);
        */
    }

    public Utente getUtenteById(int id) {
    
        try{
            Connection conn=DriverManager.getConnection(connectionString,"nerd","nerd");
            
            String query="select * from utente"+"where id=?";
            
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
            
            String query="select id from utente"+
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
                
                //imposto la frase dell'utente
                corrente.setFrase(res.getString("frase"));
                
                //imposto la password dell'utente
                corrente.setPassword("password");
                
                //manca da impostare la data
                
                //aggiungo l'utente alla lista
                listaUtenti.add(corrente);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        //ritorno la lista degli utenti
        return listaUtenti;
        /*
        return this.listaUtenti;
        */
}
}
