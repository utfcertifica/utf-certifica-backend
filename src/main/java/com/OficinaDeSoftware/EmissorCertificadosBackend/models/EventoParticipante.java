package com.OficinaDeSoftware.EmissorCertificadosBackend.models;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_evento_participante", sequenceName = "seq_evento_participante", allocationSize = 1, initialValue = 1)
public class EventoParticipante {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_evento_participante")
    private int idEventoParticipante;

    private String idEventoUsuario;
    private String idEvento;
    private String nrUuidParticipante;
    private String dsEmail;
}
