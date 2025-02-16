/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rayha
 */
public  class Magazine extends Ouvrages {
    
private LocalDate publication;
private  static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
/*car c'est un variable */

    public Magazine(LocalDate publication, String titre, String isbn, double prix, boolean best, int nbExmp) {
        super(titre, isbn, prix, best, nbExmp);
        this.publication = publication;
    }
//getters and setters 
    public LocalDate getPublication() {
        return publication;
    }

    public void setPublication(LocalDate publication) {
        this.publication = publication;
    }

 

@Override
public String toString() {
    return super.toString() + // Appelle la méthode toString() de la classe parente Ouvrages
           ", Date de publication='" + publication.format(dtf) + '\'' +
           '}';
}

    @Override
    public double calculerPrix() {
        if (this.best)
        return this.prix*1.1;
        else 
            return this.prix;
    }

    @Override
    public String gettype() {
        return "magazine";
    }

 
    
}
