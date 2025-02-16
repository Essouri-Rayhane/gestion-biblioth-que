/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rayha
 */
public class Dict extends Volume implements Emprintable {

    private String langage;
    private int nbmot;

    public Dict(String langage, int nbmot, String titre, String isbn, double prix, boolean best, int nbExmp) {
        super(titre, isbn, prix, best, nbExmp);
        this.langage = langage;
        this.nbmot = nbmot;
    }
    //getters and setters

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public int getNbmot() {
        return nbmot;
    }

    public void setNbmot(int nbmot) {
        this.nbmot = nbmot;
    }
    //methode abstraite

    @Override
    public String gettype() {
        return "DICTIONNAIRE";
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Langage='" + langage + '\''
                + ", Nombre de mots=" + nbmot
                + ", Type='" + gettype() + '\''
                + '}';
    }

    @Override
    public int getDureeDEmprint() {
        return 30;
    }

}
