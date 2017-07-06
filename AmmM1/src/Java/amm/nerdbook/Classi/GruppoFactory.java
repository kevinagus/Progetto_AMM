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
import java.util.*;

/**
 *
 * @author Kevin
 */
public class GruppoFactory {
    private static GruppoFactory singleton;
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB
    
    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    private GruppoFactory() {
    }
    
    public List<Gruppo> getListaGruppi(){
        List<Gruppo> listaGruppi =new ArrayList<>();
        
        try{
            Connection conn= DriverManager.getConnection(connectionString,"nerd","nerd");
            
            String query="select * from gruppo";
            
            PreparedStatement stmt=conn.prepareStatement(query);
            
            ResultSet res=stmt.executeQuery();
            
            while(res.next()){
                Gruppo corr=new Gruppo();
                
                corr.setId(res.getInt("group_id"));
                corr.setNome(res.getString("nome"));
                
                listaGruppi.add(corr);
            }
            
            stmt.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return listaGruppi;
    }
    
    public Gruppo getGruppoById(int id){
        try{
            Connection conn= DriverManager.getConnection(connectionString,"nerd","nerd");
            
            String query="select * from gruppo where group_id=?";
            
            PreparedStatement stmt=conn.prepareStatement(query);
            
            stmt.setInt(1,id);
            
            ResultSet res=stmt.executeQuery();
            
            if(res.next()){
                 Gruppo corrente=new Gruppo();
                 corrente.setId(res.getInt("group_id"));
                 corrente.setNome(res.getString("nome"));
                 
                stmt.close();
                conn.close();
                return corrente;
            }
            
            stmt.close();
            conn.close();
                
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }

}
