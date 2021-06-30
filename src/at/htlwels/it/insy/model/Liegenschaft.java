package at.htlwels.it.insy.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Liegenschaft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    private String einlagezahl;
    private String katestralgemeinde;

    @OneToMany(mappedBy = "liegenschaft", fetch = FetchType.LAZY)
    private List<Gebaeude> gebaeude = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adresseOID", nullable = false)
    private Adresse adresse;

    public Liegenschaft() {
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public List<Gebaeude> getGebaeude() {
        return gebaeude;
    }

    public void setGebaeude(List<Gebaeude> gebaeude) {
        this.gebaeude = gebaeude;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getEinlagezahl() {
        return einlagezahl;
    }

    public void setEinlagezahl(String einlagezahl) {
        this.einlagezahl = einlagezahl;
    }

    public String getKatestralgemeinde() {
        return katestralgemeinde;
    }

    public void setKatestralgemeinde(String katestralgemeinde) {
        this.katestralgemeinde = katestralgemeinde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Liegenschaft that = (Liegenschaft) o;

        if (einlagezahl != null ? !einlagezahl.equals(that.einlagezahl) : that.einlagezahl != null) return false;
        return katestralgemeinde != null ? katestralgemeinde.equals(that.katestralgemeinde) : that.katestralgemeinde == null;
    }

    @Override
    public int hashCode() {
        int result = einlagezahl != null ? einlagezahl.hashCode() : 0;
        result = 31 * result + (katestralgemeinde != null ? katestralgemeinde.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Liegenschaft{" +
                "einlagezahl='" + einlagezahl + '\'' +
                ", katestralgemeinde='" + katestralgemeinde + '\'' +
                '}';
    }
}
