/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rayha
 */
public class Bibliothecaire implements Gerable {

    private ArrayList<Adherent> adherents;
    private ArrayList<Ouvrages> lesouvrages;
    private String nom;
    private int CIN;

    public Bibliothecaire(String nom, int CIN) {
        this.adherents = new ArrayList<>();
        this.lesouvrages = new ArrayList<>();
        this.nom = nom;
        this.CIN = CIN;
    }

    Bibliothecaire() {
         this.adherents = new ArrayList<>();
        this.lesouvrages = new ArrayList<>();
        
    }

    @Override
    public Ouvrages rechercheOuvByIsdn(String isbn) {
        if (!this.lesouvrages.isEmpty()) {
            for (Ouvrages o : this.lesouvrages) {
                if (o.isbn == isbn && o.isDisponible()) {
                    return o;
                }
            }
        }
        return null;
    }

    @Override
    public void ajoutouvrage(Ouvrages ouvrage) {
        Ouvrages o = rechercheOuvByIsdn(ouvrage.isbn);
        if (o != null) {

            o.nbExmp = o.nbExmp++;

        } else {
            this.lesouvrages.add(ouvrage);
        }
    }

    @Override
    /*contarinte */
    public void effacerouvrage(String isbn) {
        Ouvrages o = rechercheOuvByIsdn(isbn);
        if (o != null) {
            this.lesouvrages.remove(o);
            o.nbExmp = o.nbExmp--;

        } else {
            System.out.println(" l'ouvrage n'existe pas !! ");
        }

    }

    @Override
    public void allouvrage() {
        for (Ouvrages o : this.lesouvrages) {
            System.out.println(o);

        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Adherent rechercheAdherentbyCin(int cin) {
        if (!this.adherents.isEmpty()) {
            for (Adherent A : this.adherents) {
                if (A.getCin() == cin) {
                    return A;
                }
            }
        }
        return null;
    }

    @Override
    public void inscrireAdherent(Adherent ad) {
        this.adherents.add(ad);
    }

    /*pas de prets emprint */
    @Override
    public void desinscrireAdherent(int cin) {
        Adherent ad = rechercheAdherentbyCin(cin);
        if (ad != null && ad.getNbemp() != 0) {
            this.adherents.add(ad);

        } else {
            System.out.println(" ne peut pas etre supprimer il a encore des emprints non retournée !! ");
        }
    }

    @Override
    public void allinscription() {
        for (Adherent ad : this.adherents) {
            System.out.println(ad);

        }
    }

    @Override
    public void enregistrerPret(String isbn, int cin) {
        Adherent ad = this.rechercheAdherentbyCin(cin);
        Ouvrages o = rechercheOuvByIsdn(isbn);
        if (o != null && ad != null) {
            // Rechercher l'ouvrage par son ISBN

            if (o instanceof Livre) {
                Livre livre = (Livre) o;//downcast pour forcer l'ouvrage 
                //d'etre un livre 
                if (livre.getNbExmp() == 0) {
                    System.out.println("le livre n'existe pas pour le moment!");
                } else if (ad.getNbemp() > 3) {
                    System.out.println("vous avez plus que 3 emprinte !");
                } else {/*-----------a verifier les deus boucles ---------------*/
                    for (Adherent a : this.adherents) {
                        for (Pret p : a.prets) {
                            if (p.getLivre().equals(livre)) {
                                Pret pret = new Pret(ad, livre, LocalDate.now());
                                ad.prets.add(pret);
                                //MAJ de donnes 
                                int nb = ad.getNbemp();
                                ad.setNbemp(nb++);
                                livre.nbExmp++;

                                System.out.println("Le prêt a été ajouté avec succès !");

                            } else {
                                System.out.println("l'adherent a deja emprinter un exemplaire de ce  livre ");
                            }
                        }

                    }

                }

            } else {

                System.out.println("uniquement les livres doivent etre remprunter !");
            }

        }

    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void restituerPret(int cin) {
        Adherent A = this.rechercheAdherentbyCin(cin);
        // recupiration de l'adrant
        if (A.getNbemp() == 0) {
            System.out.println("l'adherent n'a rien emprinter!");
        } else {
            //recuperation de la listes des pret de cette adrant
            for (Pret p : A.prets) {
                System.out.println("le pret numero :" + p.getNumP());
                System.out.println(" le nom de la livre ...:" + p.getLivre().getTitre());

            }
            System.out.println("donner le num de la livre a restituer : ");
            int numl = sc.nextInt();

            /*ce boucle percour la liste des pret de l' adherent  et si il trouve nomre egale ysoub lpret atheka fi variable pres ya3ni lkteb li bech yraj3ou*/
            Pret pRes = null;
            for (Pret p : A.prets) {
                if (p.getNumP() == numl) {
                    pRes = p;
                    break;
                }
            }
            //mettre a jour des donnée restetuée 
            A.prets.remove(pRes);//effacer le pert de la liste des ouvrages prets por cette adr
            int nbEPMcourant = A.getNbemp();
            A.setNbemp(nbEPMcourant--);
            //mettr a jour la date de retours
            pRes.setDateRETOUR(LocalDate.now());
            //MAJ nbre exemlaire de livre en ajoutant 1
            int nbcourant = pRes.getLivre().nbExmp;
            pRes.getLivre().setNbExmp(nbcourant++);

            System.out.println("LE PRET restituer AVEC sucéces !");

        }
    }

    @Override
    public void prolongerPret(int cin) {
        Adherent A = this.rechercheAdherentbyCin(cin);
        // recupiration de l'adrant
        if (A.getNbemp() == 0) {
            System.out.println("l'adherent n'a rien emprinter!");
        } else {
            //recuperation de la listes des pret de cette adrant
            for (Pret p : A.prets) {
                System.out.println("le pret numero :" + p.getNumP());
                System.out.println(" le nom de la livre ...:" + p.getLivre().getTitre());

            }
            System.out.println("donner le num de la livre a prologer : ");
            int numl = sc.nextInt();

            /*ce boucle percour la liste des pret de l' adherent  et si il trouve nomre egale ysoub lpret atheka fi variable pres ya3ni lkteb li bech yraj3ou*/
            Pret pRes = null;
            for (Pret p : A.prets) {
                if (p.getNumP() == numl) {
                    pRes = p;
                    break;
                }
            }
            System.out.println("donner le nombre de jour a ajouter ");
            int jour = sc.nextInt();
            pRes.prolongerEmprint(jour);
        }
    }

    @Override
    public void allemprunt() {
        for (Adherent A : this.adherents) {
            System.out.println("Adherent :" + A.getNom());
            // Vérification si l'adhérent a des prêts et affichage de la liste des prêts
            if (A.prets != null && A.prets.size() >= 0) {

                System.out.println("Liste des prêts:");
                for (Pret p : A.prets) {
                    System.out.println(p);  // Ajout d'un saut de ligne après chaque prêt pour plus de clarté
                }
            } else {
                System.out.println("\"Aucun prêt en cours.\\n\"");
            }
        }

    }

}
