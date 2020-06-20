package at.htlwels.it.insy.model;

import java.sql.Date;

public class Bewohner {

    private Date geburtsDatum;
    private Date einzugsDatum;
    private Date auszugsDatum;
    private String geburtsOrt;

    public Bewohner() {
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
