package at.htlwels.it.insy.model;

public class Gebaeude {

    private String interneKennzeichnung;
    private String interneNummer;

    public Gebaeude() {
    }

    public String getInterneKennzeichnung() {
        return interneKennzeichnung;
    }

    public void setInterneKennzeichnung(String interneKennzeichnung) {
        this.interneKennzeichnung = interneKennzeichnung;
    }

    public String getInterneNummer() {
        return interneNummer;
    }

    public void setInterneNummer(String interneNummer) {
        this.interneNummer = interneNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gebaeude gebaeude = (Gebaeude) o;

        if (interneKennzeichnung != null ? !interneKennzeichnung.equals(gebaeude.interneKennzeichnung) : gebaeude.interneKennzeichnung != null)
            return false;
        return interneNummer != null ? interneNummer.equals(gebaeude.interneNummer) : gebaeude.interneNummer == null;
    }

    @Override
    public int hashCode() {
        int result = interneKennzeichnung != null ? interneKennzeichnung.hashCode() : 0;
        result = 31 * result + (interneNummer != null ? interneNummer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Gebaeude{" +
                "interneKennzeichnung='" + interneKennzeichnung + '\'' +
                ", interneNummer='" + interneNummer + '\'' +
                '}';
    }
}
