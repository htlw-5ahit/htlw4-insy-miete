package at.htlwels.it.insy.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bewohner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long oid;
    
    private Date geburtsDatum;
    private Date einzugsDatum;
    private Date auszugsDatum;
    private String geburtsOrt;

    @ManyToMany(mappedBy = "bewohner")
    private List<Wohnung> wohnungen = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "privatMieterOID", nullable = false)
    private PrivatMieter privatMieter;

    public Bewohner() {
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public PrivatMieter getPrivatMieter() {
        return privatMieter;
    }

    public void setPrivatMieter(PrivatMieter privatMieter) {
        this.privatMieter = privatMieter;
    }

    public Date getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public Date getEinzugsDatum() {
        return einzugsDatum;
    }

    public void setEinzugsDatum(Date einzugsDatum) {
        this.einzugsDatum = einzugsDatum;
    }

    public Date getAuszugsDatum() {
        return auszugsDatum;
    }

    public void setAuszugsDatum(Date auszugsDatum) {
        this.auszugsDatum = auszugsDatum;
    }

    public String getGeburtsOrt() {
        return geburtsOrt;
    }

    public void setGeburtsOrt(String geburtsOrt) {
        this.geburtsOrt = geburtsOrt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bewohner bewohner = (Bewohner) o;

        if (geburtsDatum != null ? !geburtsDatum.equals(bewohner.geburtsDatum) : bewohner.geburtsDatum != null)
            return false;
        if (einzugsDatum != null ? !einzugsDatum.equals(bewohner.einzugsDatum) : bewohner.einzugsDatum != null)
            return false;
        if (auszugsDatum != null ? !auszugsDatum.equals(bewohner.auszugsDatum) : bewohner.auszugsDatum != null)
            return false;
        return geburtsOrt != null ? geburtsOrt.equals(bewohner.geburtsOrt) : bewohner.geburtsOrt == null;
    }

    @Override
    public int hashCode() {
        int result = geburtsDatum != null ? geburtsDatum.hashCode() : 0;
        result = 31 * result + (einzugsDatum != null ? einzugsDatum.hashCode() : 0);
        result = 31 * result + (auszugsDatum != null ? auszugsDatum.hashCode() : 0);
        result = 31 * result + (geburtsOrt != null ? geburtsOrt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bewohner{" +
                "geburtsDatum=" + geburtsDatum +
                ", einzugsDatum=" + einzugsDatum +
                ", auszugsDatum=" + auszugsDatum +
                ", geburtsOrt='" + geburtsOrt + '\'' +
                '}';
    }
}
