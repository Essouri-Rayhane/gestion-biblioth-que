

/**
 * Classe abstraite Ouvrages
 */
public abstract class Ouvrages {
    protected String titre;
    protected String isbn;
    protected double prix;
    protected boolean best;
    protected int nbExmp;
    protected boolean disponible;

    // Constructeur
    public Ouvrages(String titre, String isbn, double prix, boolean best, int nbExmp) {
        this.titre = titre;
        this.isbn = isbn;
        this.prix = prix;
        this.best = best;
        this.nbExmp = Math.max(nbExmp,0);
        this.disponible = nbExmp > 0; // Détermine si l'ouvrage est disponible
    }

    public Ouvrages() {
    }
    

    // Getters et setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isBest() {
        return best;
    }

    public void setBest(boolean best) {
        this.best = best;
    }

    public int getNbExmp() {
        return nbExmp;
    }

    public void setNbExmp(int nbExmp) {
        this.nbExmp = nbExmp;
        this.disponible = nbExmp > 0; // Met à jour la disponibilité
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Méthode abstraite
    public abstract double calculerPrix();
    public abstract String gettype();
    
    //to string 
 @Override
public String toString() {
    return "Ouvrages {" +
           "Titre='" + titre + '\'' +
           ", ISBN='" + isbn + '\'' +
           ", Prix=" + String.format("%0.3f",this.prix)+"dinars"//afficher le  prix en format de 3 virgule aprés 
            +
           ", Best-seller=" + (best ? "Oui" : "Non") +
           ", Nombre d'exemplaires=" + nbExmp +
           ", Disponible=" + (disponible ? "Oui" : "Non") +
           '}';
}
   
}
