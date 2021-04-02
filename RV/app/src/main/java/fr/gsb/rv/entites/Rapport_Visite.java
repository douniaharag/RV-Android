package fr.gsb.rv.entites;

import java.sql.Date;

public class Rapport_Visite {


    private String visiteur;
    private int num;
    private String praticien;
    private Date date ;
    private String bilan;
    private String lu ;
    private String motif;
    private int coefficientDeConfiance;


    public Rapport_Visite(String visiteur, int num, String praticien, Date date, String bilan, String lu, String motif, int coefficientDeConfiance) {
        this.visiteur = visiteur;
        this.num = num;
        this.praticien = praticien;
        this.date = date;
        this.bilan = bilan;
        this.lu = lu;
        this.motif = motif;
        this.coefficientDeConfiance = coefficientDeConfiance;
    }

    public Rapport_Visite() {

    }

    public String getVisiteur() {
        return visiteur;
    }

    public void setVisiteurMatricule(String visiteur) {
        this.visiteur = visiteur;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPraticien() {
        return praticien;
    }

    public void setPraticien(String praticien) {
        this.praticien = praticien;
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public String getVu() {
        return lu;
    }

    public void setVu(String vu) {
        this.lu = lu;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getCoefficientDeConfiance() {
        return coefficientDeConfiance;
    }

    public void setCoefficientDeConfiance(int coefficientDeConfiance) {
        this.coefficientDeConfiance = coefficientDeConfiance;
    }

    @Override
    public String toString() {
        return "Rapport_Visite{" +
                "visiteur='" + visiteur + '\'' +
                ", num=" + num +
                ", praticien=" + praticien +
                ", bilan='" + bilan + '\'' +
                ", vu='" + lu + '\'' +
                ", motif='" + motif + '\'' +
                ", coefficientDeConfiance=" + coefficientDeConfiance +
                '}';
    }
}
