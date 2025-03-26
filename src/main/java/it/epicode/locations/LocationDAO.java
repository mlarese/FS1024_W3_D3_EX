package it.epicode.locations;

import jakarta.persistence.EntityManager;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Location e) {
        em.persist(e);
    }

    public void update(Location e) {
        em.merge(e);
    }

    public void delete(Long id) {
        Location e = findById(id);
        em.remove(e);
    }

    public Location findById(Long id) {
        return em.find(Location.class, id);
    }
}
