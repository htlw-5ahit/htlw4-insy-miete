package at.htlwels.it.insy.model;

import java.sql.Date;

public class Mieter {

    private int einStuffung;
    private String status;
    private Date kontaktDatum;

    public Mieter() {
    }

    public int getEinStuffung() {
        return einStuffung;
    }

    public void setEinStuffung(int einStuffung) {
        this.einStuffung = einStuffung;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getKontaktDatum() {
        return kontaktDatum;
    }

    public void setKontaktDatum(Date kontaktDatum) {
        this.kontaktDatum = kontaktDatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mieter mieter = (Mieter) o;

        if (einStuffung != mieter.einStuffung) return false;
        if (status != null ? !status.equals(mieter.status) : mieter.status != null) return false;
        return kontaktDatum != null ? kontaktDatum.equals(mieter.kontaktDatum) : mieter.kontaktDatum == null;
    }

    @Override
    public int hashCode() {
        int result = einStuffung;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (kontaktDatum != null ? kontaktDatum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mieter{" +
                "einStuffung=" + einStuffung +
                ", status='" + status + '\'' +
                ", kontaktDatum=" + kontaktDatum +
                '}';
    }
}
