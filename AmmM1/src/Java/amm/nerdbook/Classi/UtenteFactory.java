/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class UtenteFactory {

    private static UtenteFactory singleton;

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteFactory();
        }
        return singleton;
    }

    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();

    private UtenteFactory() {

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

    }

    public Utente getUtenteById(int id) {
        for (Utente user : this.listaUtenti) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password) {
        for (Utente copiaUtente : this.listaUtenti) {
            if (copiaUtente.getNome().equals(user) && copiaUtente.getPassword().equals(password)) {
                return copiaUtente.getId();
            }
        }
        return -1;
    }
    
    public ArrayList<Utente> getListaUtenti(){
        return this.listaUtenti;
    }
}
