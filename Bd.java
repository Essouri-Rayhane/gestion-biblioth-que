/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author rayha
 */
public class Bd extends Volume implements Emprintable {

    private String illus;

    public Bd(String titre, String isbn, double prix, boolean best, int nbExmp,String illus) {
        super(titre, isbn, prix, best, nbExmp);
        this.illus=illus;
    }
    //gettrs and setters

    public String getIllus() {
        return illus;
    }

    public void setIllus(String illus) {
        this.illus = illus;
    }
    //get type

    @Override
    public String gettype() {
        return "BANDE DESSINER ";
    }

    @Override
    public String toString() {
        return super.toString()
                + // Appelle la méthode toString() de la classe parente Volume
                ", Illustrateur='" + illus + '\''
                + ", Type='" + gettype() + '\''; // Ajoute le type spécifique
    }

    @Override
    public int getDureeDEmprint() {
        return 7;
    }
}
