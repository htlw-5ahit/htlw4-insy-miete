package at.htlwels.it.insy.main;

import at.htlwels.it.insy.model.*;
import com.winklerlabs.ASCIIWriter;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.winklerlabs.ASCIIWriter.*;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "school_MySQL";
    private static EntityManagerFactory factory;
    private static EntityManager manager;


    //    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        // printSignatureOne();

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();


        System.out.println("**************************************************");
        System.out.println("**************************************************");
        System.out.println("***   Initialisierung                         ");
        System.out.println("**************************************************");


        test();
    }


    private static void test() {

        // mieter

        PrivatMieter clemens = new PrivatMieter();
        clemens.setEinStuffung(1);
        clemens.setStatus("online");
        clemens.setKontaktDatum(Date.valueOf("2021-06-30"));
        clemens.setBezeichnung("Clemens Rumpfhuber");
        clemens.setAngegebeneAnzahlMieter(2);

        PrivatMieter christoph = new PrivatMieter();
        christoph.setEinStuffung(1);
        christoph.setStatus("beschäftigt");
        christoph.setKontaktDatum(Date.valueOf("2021-06-30"));
        christoph.setBezeichnung("Christoph Schmitsberger");
        christoph.setAngegebeneAnzahlMieter(2);

        PrivatMieter tobias = new PrivatMieter();
        tobias.setEinStuffung(1);
        tobias.setStatus("abwesend");
        tobias.setKontaktDatum(Date.valueOf("2021-06-30"));
        tobias.setBezeichnung("Tobias Schmidt");
        tobias.setAngegebeneAnzahlMieter(2);

        FirmenMieter htl = new FirmenMieter();
        htl.setEinStuffung(1);
        htl.setStatus("offline");
        htl.setKontaktDatum(Date.valueOf("2021-06-30"));
        htl.setFirmenbuchNummer(10001);
        htl.setGruendungsDatum(Date.valueOf("1900-01-01"));

        // bewohner

        Bewohner bewohnerClemens = new Bewohner();
        bewohnerClemens.setPrivatMieter(clemens);
        bewohnerClemens.setGeburtsDatum(Date.valueOf("2002-10-06"));
        bewohnerClemens.setEinzugsDatum(Date.valueOf("2021-06-30"));
        bewohnerClemens.setAuszugsDatum(Date.valueOf("2025-06-30"));
        bewohnerClemens.setGeburtsOrt("Wels");

        Bewohner bewohnerChristoph = new Bewohner();
        bewohnerChristoph.setPrivatMieter(christoph);
        bewohnerChristoph.setGeburtsDatum(Date.valueOf("2003-03-08"));
        bewohnerChristoph.setEinzugsDatum(Date.valueOf("2021-06-30"));
        bewohnerChristoph.setAuszugsDatum(Date.valueOf("2025-06-30"));
        bewohnerChristoph.setGeburtsOrt("Wels");

        Bewohner bewohnerTobias = new Bewohner();
        bewohnerTobias.setPrivatMieter(tobias);
        bewohnerTobias.setGeburtsDatum(Date.valueOf("2002-10-05"));
        bewohnerTobias.setEinzugsDatum(Date.valueOf("2021-06-30"));
        bewohnerTobias.setAuszugsDatum(Date.valueOf("2025-06-30"));
        bewohnerTobias.setGeburtsOrt("Wels");

        clemens.getBewohner().add(bewohnerClemens);
        christoph.getBewohner().add(bewohnerChristoph);
        tobias.getBewohner().add(bewohnerTobias);

        // adresse

        Adresse adresse = new Adresse();
        adresse.setStrasse("Wohnungstrasse");
        adresse.setPostleitzahl(4600);
        adresse.setOrt("Wels");
        adresse.setLand("Austria");

        // liegenschaft

        Liegenschaft liegenschaft = new Liegenschaft();
        liegenschaft.setAdresse(adresse);
        liegenschaft.setEinlagezahl("idk");
        liegenschaft.setKatestralgemeinde("Lichtenegg");

        // gebauede

        Gebaeude gebaeude = new Gebaeude();
        gebaeude.setInterneKennzeichnung("Ein wunderschoenes Haus am See");
        gebaeude.setInterneNummer("100");
        gebaeude.setLiegenschaft(liegenschaft);

        liegenschaft.getGebaeude().add(gebaeude);

        // wohnung

        Wohnung wg = new Wohnung();
        wg.setInterneBezeichnung("100_1");
        wg.setAdressNummer(1);
        wg.setGebaeude(gebaeude);

        Wohnung wohnung = new Wohnung();
        wohnung.setInterneBezeichnung("100_2");
        wohnung.setAdressNummer(2);
        wohnung.setGebaeude(gebaeude);

        wg.getBewohner().add(bewohnerClemens);
        wg.getBewohner().add(bewohnerChristoph);
        wohnung.getBewohner().add(bewohnerTobias);

        gebaeude.getWohnungen().add(wg);
        gebaeude.getWohnungen().add(wohnung);

        // mietvertrag

        Mietvertrag mietvertrag = new Mietvertrag();
        mietvertrag.setMieter(clemens);
        mietvertrag.setAusstellungsDatum(Date.valueOf("2021-06-30"));
        mietvertrag.setMietBeginn(Date.valueOf("2021-06-30"));
        mietvertrag.setMietEnde(Date.valueOf("2025-06-30"));
        mietvertrag.setMiete(1200f);
        mietvertrag.setKaution(10000f);

        Mietvertrag mietvertrag1 = new Mietvertrag();
        mietvertrag1.setMieter(tobias);
        mietvertrag1.setAusstellungsDatum(Date.valueOf("2021-06-30"));
        mietvertrag1.setMietBeginn(Date.valueOf("2021-06-30"));
        mietvertrag1.setMietEnde(Date.valueOf("2025-06-30"));
        mietvertrag1.setMiete(800f);
        mietvertrag1.setKaution(9000f);

        mietvertrag.setWohnung(wg);
        mietvertrag1.setWohnung(wohnung);

        wg.getMitvertraege().add(mietvertrag);
        wohnung.getMitvertraege().add(mietvertrag1);

        // persistieren

        manager.getTransaction().begin();

        manager.persist(clemens);
        manager.persist(christoph);
        manager.persist(tobias);
        manager.persist(htl);

        manager.persist(bewohnerClemens);
        manager.persist(bewohnerChristoph);
        manager.persist(bewohnerTobias);

        manager.persist(wg);
        manager.persist(wohnung);

        manager.persist(adresse);
        manager.persist(liegenschaft);
        manager.persist(gebaeude);


        manager.persist(mietvertrag);
        manager.persist(mietvertrag1);

        manager.getTransaction().commit();

        System.out.println("-> Katastrophe BEENDET. JUHUUUU");
    }

}