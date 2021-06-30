package at.htlwels.it.insy.model;

import jakarta.persistence.Entity;

import java.sql.Date;

@Entity
public class FirmenMieter extends Mieter {

    private int FirmenbuchNummer;
    private Date gruendungsDatum;

    public FirmenMieter() {
    }

    public int getFirmenbuchNummer() {
        return FirmenbuchNummer;
    }

    public void setFirmenbuchNummer(int firmenbuchNummer) {
        FirmenbuchNummer = firmenbuchNummer;
    }

    public Date getGruendungsDatum() {
        return gruendungsDatum;
    }

    public void setGruendungsDatum(Date gruendungsDatum) {
        this.gruendungsDatum = gruendungsDatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FirmenMieter that = (FirmenMieter) o;

        if (FirmenbuchNummer != that.FirmenbuchNummer) return false;
        return gruendungsDatum != null ? gruendungsDatum.equals(that.gruendungsDatum) : that.gruendungsDatum == null;
    }

    @Override
    public int hashCode() {
        int result = FirmenbuchNummer;
        result = 31 * result + (gruendungsDatum != null ? gruendungsDatum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FirmenMieter{" +
                "FirmenbuchNummer=" + FirmenbuchNummer +
                ", gruendungsDatum=" + gruendungsDatum +
                '}';
    }
}
