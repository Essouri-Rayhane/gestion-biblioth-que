/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rayha
 */
public abstract class Volume extends Ouvrages {
    
     

    public Volume(String titre, String isbn, double prix, boolean best, int nbExmp) {
        super(titre, isbn, prix, best, nbExmp);
    }
     public Volume() {
       
    }
    @Override
    public double calculerPrix()
    {
    if(this.best)
     return (this.prix)*1.3;
    else
        return this.prix;
    }
    
    
}