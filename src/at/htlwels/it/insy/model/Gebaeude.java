package at.htlwels.it.insy.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Gebaeude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    
    private String interneKennzeichnung;
    private String interneNummer;

    @OneToMany(mappedBy = "gebaeude", fetch = FetchType.LAZY)
    private List<Wohnung> wohnungen = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "liegenschaftOID", nullable = false)
    private Liegenschaft liegenschaft;

    public Gebaeude() {
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public List<Wohnung> getWohnungen() {
        return wohnungen;
    }

    public void setWohnungen(List<Wohnung> wohnungen) {
        this.wohnungen = wohnungen;
    }

    public Liegenschaft getLiegenschaft() {
        return liegenschaft;
    }

    public void setLiegenschaft(Liegenschaft liegenschaft) {
        this.liegenschaft = liegenschaft;
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
