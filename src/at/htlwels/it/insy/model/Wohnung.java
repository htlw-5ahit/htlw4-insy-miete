package at.htlwels.it.insy.model;

public class Wohnung {

    private String interneBezeichnung;
    private int adressNummer;

    public Wohnung() {
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
