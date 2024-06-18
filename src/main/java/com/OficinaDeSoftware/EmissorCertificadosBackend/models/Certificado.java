package com.OficinaDeSoftware.EmissorCertificadosBackend.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@SequenceGenerator(name = "seq_certificado", sequenceName = "seq_certificado", allocationSize = 1, initialValue = 1)
public class Certificado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Tipo Long para geração automática de IDs

    private Long idEvento;    
    private String nomeEvento;
    private String ministrante;
    private LocalDate dataEvento;
    private int nrCargaHoraria;
    private String fileCertificado;
    private String idCertificadoModelo;
}
