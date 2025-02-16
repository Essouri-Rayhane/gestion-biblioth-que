

import java.util.ArrayList;

public class Adherent {
    private int cin;
    private String nom;
    private String prenom;
    private int nbemp = 0;
    protected  ArrayList <Pret> prets;

    // Constructeurs
    public Adherent() {
    }

    public Adherent(int cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.prets=new ArrayList <>();
    }

    // Getters et setters
    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNbemp() {
        return nbemp;
    }

    public void setNbemp(int nbemp) {
        this.nbemp = nbemp;
    }

    public ArrayList<Pret> getPrets() {
        return prets;
    }

    public void setPrets(ArrayList<Pret> prets) {
        this.prets = prets;
    }

    
    // Méthode toString pour afficher les informations de l'adhérent
   
    public void affichePrets()
    {
        
    }
    
    public String AfficherADr() {
      // Initialisation de la chaîne de caractères avec un en-tête
    String str = "--------------------------\n";
    str += "Adhérent\n";
    str += "--------------------------\n";
    
    // Affichage des informations de l'adhérent
    str += "CIN: " + cin + "\n";
    str += "Nom: " + nom + "\n";
    str += "Prénom: " + prenom + "\n";
    str += "Nombre d'emprunts: " + nbemp + "\n";
    
    // Vérification si l'adhérent a des prêts et affichage de la liste des prêts
    if (this.prets != null && this.prets.size()>= 0) {
        str += "Liste des prêts:\n";
        for (Pret p : this.prets) {
            str += p + "\n";  // Ajout d'un saut de ligne après chaque prêt pour plus de clarté
        }
    } else {
        str += "Aucun prêt en cours.\n";
    }
    
    // Retourner la chaîne de caractères formatée
    return str;
}
        
    }

