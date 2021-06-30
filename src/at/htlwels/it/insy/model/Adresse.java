package at.htlwels.it.insy.model;

import jakarta.persistence.*;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    private String strasse;
    private int postleitzahl;
    private String ort;
    private String land;

    @OneToOne(mappedBy = "adresse")
    private Liegenschaft liegenschaft;

    public Adresse() {
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Liegenschaft getLiegenschaft() {
        return liegenschaft;
    }

    public void setLiegenschaft(Liegenschaft liegenschaft) {
        this.liegenschaft = liegenschaft;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        if (postleitzahl != adresse.postleitzahl) return false;
        if (strasse != null ? !strasse.equals(adresse.strasse) : adresse.strasse != null) return false;
        if (ort != null ? !ort.equals(adresse.ort) : adresse.ort != null) return false;
        return land != null ? land.equals(adresse.land) : adresse.land == null;
    }

    @Override
    public int hashCode() {
        int result = strasse != null ? strasse.hashCode() : 0;
        result = 31 * result + postleitzahl;
        result = 31 * result + (ort != null ? ort.hashCode() : 0);
        result = 31 * result + (land != null ? land.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "strasse='" + strasse + '\'' +
                ", postleitzahl=" + postleitzahl +
                ", ort='" + ort + '\'' +
                ", land='" + land + '\'' +
                '}';
    }
}
