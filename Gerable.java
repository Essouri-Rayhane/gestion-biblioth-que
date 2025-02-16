/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rayha
 */
public interface Gerable {
    Ouvrages rechercheOuvByIsdn(String isbn);
   void ajoutouvrage (Ouvrages ouvrage );
    void effacerouvrage(String isbn);
    void allouvrage();
    Adherent rechercheAdherentbyCin(int cin);
    void inscrireAdherent (Adherent ad);
     void desinscrireAdherent (int cin);
     void allinscription();
     void enregistrerPret(String isbn,int cin);
     void prolongerPret(int cin);
     void restituerPret(int cin);
     void allemprunt();
}
