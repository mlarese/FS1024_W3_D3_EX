package it.epicode.eventi.gara_atletica;

import it.epicode.eventi.Evento;
import it.epicode.eventi.TipoEvento;
import it.epicode.locations.Location;
import it.epicode.partecipazioni.Partecipazione;
import it.epicode.persone.Persona;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {

    @ManyToMany
    private Set<Persona> atleti;

    // uno stesso atleta può vicere più gare, ogni gara ha un solo vincitore
    @ManyToOne
    private Persona vincitore;

    public GaraDiAtletica() {

    }

    public GaraDiAtletica(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location, Set<Persona> atleti, Persona vincitore) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
