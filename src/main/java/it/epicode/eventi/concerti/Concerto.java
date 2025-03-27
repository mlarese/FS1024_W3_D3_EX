package it.epicode.eventi.concerti;

import it.epicode.eventi.Evento;
import it.epicode.eventi.TipoEvento;
import it.epicode.locations.Location;
import it.epicode.partecipazioni.Partecipazione;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.NamedQuery;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Concerto extends Evento {

    @Enumerated( EnumType.STRING)
    private Genere genere;
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location, Genere genere, boolean inStreaming) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
