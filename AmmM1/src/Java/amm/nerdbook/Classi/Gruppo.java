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
public class Gruppo {
    private int id;
    private String nome;
    
    public Gruppo(){
        this.id=0;
        this.nome="";
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }   
    
    public String getNome(){
        return this.nome;
    }
    
    public int getId(){
        return this.id;
    }
}