package it.epicode.eventi.partite_di_calcio;

import it.epicode.eventi.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainPartite {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);

        PartitaDiCalcio p = new PartitaDiCalcio(null, "Partita 1", null, "Partita di calcio", null, 1000, null, null, "Juventus", "Inter", "Juventus", 2, 1);
        PartitaDiCalcio p2 = new PartitaDiCalcio(null, "Partita 2", null, "Partita di calcio", null, 1000, null, null, "Juventus", "Inter", "Inter", 2, 1);
        PartitaDiCalcio p3 = new PartitaDiCalcio(null, "Partita 3", null, "Partita di calcio", null, 1000, null, null, "Juventus", "Inter", "Inter", 1, 2);

        em.getTransaction().begin();

        em.persist(p);
        em.persist(p2);
        em.persist(p3);

        em.getTransaction().commit();

        List<PartitaDiCalcio> vinteInCasa = eventoDAO.getPartiteVinteInCasa();
        System.out.println("Partite vinte in casa: ");
        for (PartitaDiCalcio partitaDiCalcio : vinteInCasa) {
            System.out.println(partitaDiCalcio.getTitolo());
        }

        List<PartitaDiCalcio> vinteInTrasferta = eventoDAO.getPartiteVinteInTrasferta();
        System.out.println("Partite vinte in trasferta: ");
        for (PartitaDiCalcio partitaDiCalcio : vinteInTrasferta) {
            System.out.println(partitaDiCalcio.getTitolo());
        }


        em.close();
        emf.close();


    }
}
