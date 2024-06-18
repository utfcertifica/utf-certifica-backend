package com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_evento", sequenceName = "seq_evento", allocationSize = 1, initialValue = 1)
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Tipo Long para geração automática de IDs

    private String dsNome;
    private LocalDateTime dhInicio;
    private LocalDateTime dhFim;
    private String dsResumo;
    private String dsInformacoes;
    private String nrUuidResponsavel;
    private String dsBanner;

    private Long idLocal;
}
