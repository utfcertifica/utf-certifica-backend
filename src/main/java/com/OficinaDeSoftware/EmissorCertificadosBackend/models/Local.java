package com.OficinaDeSoftware.EmissorCertificadosBackend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@SequenceGenerator(name = "seq_local", sequenceName = "seq_local", allocationSize = 1, initialValue = 1)
public class Local implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_local")
    private String idLocal;

    private String dsAuditorio;
    private String dsBloco;
    private String dsSala;
    private Integer qtdParticipoantes;
}
