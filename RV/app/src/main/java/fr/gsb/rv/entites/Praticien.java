package fr.gsb.rv.entites;

public class Praticien {


    private int num;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private int coefficientNotoriete;


    public Praticien(int num, String nom, String prenom, int coefficientNotoriete) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.coefficientNotoriete = coefficientNotoriete;
    }

    public Praticien(int num, String nom, String prenom, String adresse, String codePostal, String ville, int coefficientNotoriete) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.coefficientNotoriete = coefficientNotoriete;

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCoefficientNotoriete() {
        return coefficientNotoriete;
    }

    public void setCoefficientNotoriete(int coefficientNotoriete) {
        this.coefficientNotoriete = coefficientNotoriete;
    }


    @Override
    public String toString() {
        return "Praticien{" +
                "num=" + num +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", coefficientNotoriete='" + coefficientNotoriete + '\'' +
                '}';
    }
}