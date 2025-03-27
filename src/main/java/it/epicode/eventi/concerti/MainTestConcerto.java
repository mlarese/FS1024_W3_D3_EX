package it.epicode.eventi.concerti;

import it.epicode.eventi.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainTestConcerto {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);

        Concerto c = new Concerto(null, "Concerto 1", null, "Concerto di Vasco Rossi", null, 1000, null, null, Genere.ROCK, true);
        Concerto c2 = new Concerto(null, "Concerto 2", null, "Concerto di Vasco Rossi", null, 1000, null, null, Genere.CLASSICO, false);
        Concerto c3 = new Concerto(null, "Concerto 3", null, "Concerto di Vasco Rossi", null, 1000, null, null, Genere.ROCK, true);
        em.getTransaction().begin();

            em.persist(c);
            em.persist(c2);
            em.persist(c3);

        em.getTransaction().commit();


        List<Concerto> concertiInStreaming = eventoDAO.getConcertiInStreaming(true);
        System.out.println("Concerti in streaming: ");
        for (Concerto concerto : concertiInStreaming) {
            System.out.println(concerto.getTitolo());
        }

        List<Concerto> concertiPerGenere = eventoDAO.getConcertiPerGenere(Genere.ROCK);

        System.out.println("Concerti per genere: ");
        for (Concerto concerto : concertiPerGenere) {
            System.out.println(concerto.getTitolo());
        }

        em.close();
        emf.close();
    }
}
