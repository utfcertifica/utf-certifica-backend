package com.OficinaDeSoftware.EmissorCertificadosBackend.models;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_evento", sequenceName = "seq_evento", allocationSize = 1, initialValue = 1)
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dsNome;
    private LocalDate dhInicio;
    private LocalDate dhFim;
    private String dsResumo;
    private String dsInformacoes;
    private String nrUuidResponsavel;
    private String dsBanner;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DateEvent> dateEvents;
}
