package it.epicode.partecipazioni;

import jakarta.persistence.EntityManager;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Partecipazione e) {
        em.persist(e);
    }

    public void update(Partecipazione e) {
        em.merge(e);
    }

    public void delete(Long id) {
        Partecipazione e = findById(id);
        em.remove(e);
    }

    public Partecipazione findById(Long id) {
        return em.find(Partecipazione.class, id);
    }
}
