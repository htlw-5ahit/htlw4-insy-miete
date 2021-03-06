package at.htlwels.it.insy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PrivatMieter extends Mieter {

    private String bezeichnung;
    private int angegebeneAnzahlMieter;

    @OneToMany(mappedBy = "privatMieter", fetch = FetchType.LAZY)
    private List<Bewohner> bewohner = new ArrayList<>();

    public PrivatMieter() {
    }

    public List<Bewohner> getBewohner() {
        return bewohner;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getAngegebeneAnzahlMieter() {
        return angegebeneAnzahlMieter;
    }

    public void setAngegebeneAnzahlMieter(int angegebeneAnzahlMieter) {
        this.angegebeneAnzahlMieter = angegebeneAnzahlMieter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PrivatMieter that = (PrivatMieter) o;

        if (angegebeneAnzahlMieter != that.angegebeneAnzahlMieter) return false;
        return bezeichnung != null ? bezeichnung.equals(that.bezeichnung) : that.bezeichnung == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        result = 31 * result + angegebeneAnzahlMieter;
        return result;
    }

    @Override
    public String toString() {
        return "PrivatMieter{" +
                "bezeichnung='" + bezeichnung + '\'' +
                ", angegebeneAnzahlMieter=" + angegebeneAnzahlMieter +
                '}';
    }
}
