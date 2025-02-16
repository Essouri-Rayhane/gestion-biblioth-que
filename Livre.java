/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author rayha
 */
public class Livre extends Volume implements Emprintable{
    
    private String auteur;
    private String genre;

    public Livre(String auteur, String genre, String titre, String isbn, double prix, boolean best, int nbExmp) {
        super(titre, isbn, prix, best, nbExmp);
        this.auteur = auteur;
        this.genre = genre;
    }

    public Livre() {
        
    }
    
    //getters and setters 

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    
    @Override
    public String gettype() {
        return "LIVRE" ;
        
    }
    // Implémentation de la méthode de l'interface Emprintable
    @Override
    public int getDureeDEmprint() {
        return 14; // Durée d'emprunt de 14 jours
    }
     @Override
    public String toString() {
        return super.toString() +
               ", Auteur='" + auteur + '\'' +"genre"+this.genre+
               '}';
    }
     
}
