package at.htlwels.it.insy.model;

public class Liegenschaft {

    private String einlagezahl;
    private String katestralgemeinde;

    public Liegenschaft() {
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
