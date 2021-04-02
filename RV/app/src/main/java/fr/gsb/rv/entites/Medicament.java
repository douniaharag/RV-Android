package fr.gsb.rv.entites;

public class Medicament {

    private String depotLegal;
    private String nomCommercial;
    private String famille;
    private String composition;
    private String effets;
    private String contreIndications;
    private double prixEchantillon;


    public Medicament(String depotLegal, String nomCommercial, String famille, String composition, String effets, String contreIndications, double prixEchantillon) {
        this.depotLegal = depotLegal;
        this.nomCommercial = nomCommercial;
        this.famille = famille;
        this.composition = composition;
        this.effets = effets;
        this.contreIndications = contreIndications;
        this.prixEchantillon = prixEchantillon;
    }

    public String getDepotLegal() {
        return depotLegal;
    }

    public void setDepotLegal(String depotLegal) {
        this.depotLegal = depotLegal;
    }

    public String getNomCommercial() {
        return nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getEffets() {
        return effets;
    }

    public void setEffets(String effets) {
        this.effets = effets;
    }

    public String getContreIndications() {
        return contreIndications;
    }

    public void setContreIndications(String contreIndications) {
        this.contreIndications = contreIndications;
    }

    public double getPrixEchantillon() {
        return prixEchantillon;
    }

    public void setPrixEchantillon(double prixEchantillon) {
        this.prixEchantillon = prixEchantillon;
    }


    @Override
    public String toString() {
        return "Medicament{" +
                "depotLegal='" + depotLegal + '\'' +
                ", nomCommercial='" + nomCommercial + '\'' +
                ", famille='" + famille + '\'' +
                ", composition='" + composition + '\'' +
                ", effets='" + effets + '\'' +
                ", contreIndications='" + contreIndications + '\'' +
                ", prixEchantillon=" + prixEchantillon +
                '}';
    }
}