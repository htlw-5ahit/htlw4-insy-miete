package at.htlwels.it.insy.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Mietvertrag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long oid;

    private Date ausstellungsDatum;
    private Date mietBeginn;
    private Date mietEnde;
    private float miete;
    private float kaution;

    @ManyToOne
    @JoinColumn(name = "mieterOID", nullable = false)
    private Mieter mieter;

    @ManyToOne
    @JoinColumn(name = "wohnungOID", nullable = false)
    private Wohnung wohnung;

    public Mietvertrag() {
    }

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public Mieter getMieter() {
        return mieter;
    }

    public void setMieter(Mieter mieter) {
        this.mieter = mieter;
    }

    public Wohnung getWohnung() {
        return wohnung;
    }

    public void setWohnung(Wohnung wohnung) {
        this.wohnung = wohnung;
    }

    public Date getAusstellungsDatum() {
        return ausstellungsDatum;
    }

    public void setAusstellungsDatum(Date ausstellungsDatum) {
        this.ausstellungsDatum = ausstellungsDatum;
    }

    public Date getMietBeginn() {
        return mietBeginn;
    }

    public void setMietBeginn(Date mietBeginn) {
        this.mietBeginn = mietBeginn;
    }

    public Date getMietEnde() {
        return mietEnde;
    }

    public void setMietEnde(Date mietEnde) {
        this.mietEnde = mietEnde;
    }

    public float getMiete() {
        return miete;
    }

    public void setMiete(float miete) {
        this.miete = miete;
    }

    public float getKaution() {
        return kaution;
    }

    public void setKaution(float kaution) {
        this.kaution = kaution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mietvertrag that = (Mietvertrag) o;

        if (Float.compare(that.miete, miete) != 0) return false;
        if (Float.compare(that.kaution, kaution) != 0) return false;
        if (ausstellungsDatum != null ? !ausstellungsDatum.equals(that.ausstellungsDatum) : that.ausstellungsDatum != null)
            return false;
        if (mietBeginn != null ? !mietBeginn.equals(that.mietBeginn) : that.mietBeginn != null) return false;
        return mietEnde != null ? mietEnde.equals(that.mietEnde) : that.mietEnde == null;
    }

    @Override
    public int hashCode() {
        int result = ausstellungsDatum != null ? ausstellungsDatum.hashCode() : 0;
        result = 31 * result + (mietBeginn != null ? mietBeginn.hashCode() : 0);
        result = 31 * result + (mietEnde != null ? mietEnde.hashCode() : 0);
        result = 31 * result + (miete != +0.0f ? Float.floatToIntBits(miete) : 0);
        result = 31 * result + (kaution != +0.0f ? Float.floatToIntBits(kaution) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mietvertrag{" +
                "ausstellungsDatum=" + ausstellungsDatum +
                ", mietBeginn=" + mietBeginn +
                ", mietEnde=" + mietEnde +
                ", miete=" + miete +
                ", kaution=" + kaution +
                '}';
    }
}
