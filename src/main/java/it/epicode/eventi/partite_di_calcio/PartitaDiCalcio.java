package it.epicode.eventi.partite_di_calcio;

import it.epicode.eventi.Evento;
import it.epicode.eventi.TipoEvento;
import it.epicode.locations.Location;
import it.epicode.partecipazioni.Partecipazione;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

import java.time.LocalDate;
import java.util.List;

@Entity
@NamedQuery(name="partita.find.vinte_in_casa", query="SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraCasa")
@NamedQuery(name="partita.find.vinta_in_trasferta",  query=" SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite")
public class PartitaDiCalcio  extends Evento {
    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int goalCasa;
    private int goalOspite;

    public PartitaDiCalcio( ) {

    }

    public PartitaDiCalcio(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location, String squadraCasa, String squadraOspite, String squadraVincente, int goalCasa, int goalOspite) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.goalCasa = goalCasa;
        this.goalOspite = goalOspite;
    }
}
