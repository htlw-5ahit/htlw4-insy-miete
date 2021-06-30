package at.htlwels.it.insy.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Wohnung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    private String interneBezeichnung;
    private int adressNummer;

    @OneToMany(mappedBy = "wohnung", fetch = FetchType.LAZY)
    private List<Mietvertrag> mitvertraege = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "gebaeudeOID", nullable = false)
    private Gebaeude gebaeude;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "WOHNUNG_BEWOHNER",
            joinColumns = {@JoinColumn (name = "WohnungOID")},
            inverseJoinColumns =  {@JoinColumn(name = "BewohnerOID")}
    )
    private List<Bewohner> bewohner = new ArrayList<>();

    public Wohnung() {
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public List<Mietvertrag> getMitvertraege() {
        return mitvertraege;
    }

    public void setMitvertraege(List<Mietvertrag> mitvertraege) {
        this.mitvertraege = mitvertraege;
    }

    public Gebaeude getGebaeude() {
        return gebaeude;
    }

    public void setGebaeude(Gebaeude gebaeude) {
        this.gebaeude = gebaeude;
    }

    public String getInterneBezeichnung() {
        return interneBezeichnung;
    }

    public void setInterneBezeichnung(String interneBezeichnung) {
        this.interneBezeichnung = interneBezeichnung;
    }

    public int getAdressNummer() {
        return adressNummer;
    }

    public void setAdressNummer(int adressNummer) {
        this.adressNummer = adressNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wohnung wohnung = (Wohnung) o;

        if (adressNummer != wohnung.adressNummer) return false;
        return interneBezeichnung != null ? interneBezeichnung.equals(wohnung.interneBezeichnung) : wohnung.interneBezeichnung == null;
    }

    @Override
    public int hashCode() {
        int result = interneBezeichnung != null ? interneBezeichnung.hashCode() : 0;
        result = 31 * result + adressNummer;
        return result;
    }

    @Override
    public String toString() {
        return "Wohnung{" +
                "interneBezeichnung='" + interneBezeichnung + '\'' +
                ", adressNummer=" + adressNummer +
                '}';
    }
}
