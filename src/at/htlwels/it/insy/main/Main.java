package at.htlwels.it.insy.main;

import at.htlwels.it.insy.model.*;
import com.winklerlabs.ASCIIWriter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.winklerlabs.ASCIIWriter.*;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "school_SQLServer";
    private static EntityManagerFactory factory;


//    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        printSignatureOne();
        // Nicht vergessen, im Dadenbanksystem die entsprechende Datenbank
        // 'Miete" anlegen.

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();


        System.out.println("**************************************************");
        System.out.println("**************************************************");
        System.out.println("***   Initialisierung                         ");
        System.out.println("**************************************************");

        entityManager.getTransaction().commit();



        

    }

 

}