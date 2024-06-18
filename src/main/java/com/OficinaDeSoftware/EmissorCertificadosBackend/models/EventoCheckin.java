package com.OficinaDeSoftware.EmissorCertificadosBackend.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;


import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_evento_checkin", sequenceName = "seq_evento_checkin", allocationSize = 1, initialValue = 1)
public class EventoCheckin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_evento_checkin")
    private String  idEventoCheckin;

    private LocalDateTime dhCheckin;
    private LocalDateTime dhCheckout;
    private String nrUuidParticipante;
    private String idEventoData;
}

