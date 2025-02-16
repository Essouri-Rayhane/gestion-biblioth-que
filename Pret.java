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
public class Pret implements Prolengeable {

    private int numP;
    private Adherent AD;
    private Livre livre;
    private LocalDate dateEmp;
    private LocalDate dateRETOUR;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /*car c'est un variable */
    public Pret( Adherent AD, Livre livre, LocalDate dateEmp) {
        this.numP = numP++;
        this.AD = AD;
        this.livre = livre;
        this.dateEmp = dateEmp;
        this.dateRETOUR = null;
    }

    public int getNumP() {
        return numP;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }

    public Adherent getAD() {
        return AD;
    }

    public void setAD(Adherent AD) {
        this.AD = AD;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public LocalDate getDateEmp() {
        return dateEmp;
    }

    public void setDateEmp(LocalDate dateEmp) {
        this.dateEmp = dateEmp;
    }

    public LocalDate getDateRETOUR() {
        return dateRETOUR;
    }

    public void setDateRETOUR(LocalDate dateRETOUR) {
        this.dateRETOUR = dateRETOUR;
    }

    @Override

    public String toString() {
        return "--------------------------\n"
                + "Prêt\n"
                + "--------------------------\n"
                + "Adhérent : " + this.AD + "\n"
                + "Livre : " + this.livre + "\n"
                + "Numéro de prêt : " + this.numP + "\n"
                + "Date d'emprunt : " + this.dateEmp + "\n"
                + "Date de retour prévue : " + this.dateRETOUR + "\n"
                + "--------------------------";

    }
// prolenger emprint 

    @Override
    public void prolongerEmprint(int jours) {
        //cette methode exted la date en ajoutant le nombre des jours ajouter avc plus days 
        this.dateRETOUR = this.dateRETOUR.plusDays(jours);
    }
}
