package com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_evento_personalizado", sequenceName = "seq_evento_personalizado", allocationSize = 1, initialValue = 1)
public class EventoPersonalizado {
    
    private String nome;
    private String descricao;
    private String dsDateStart;
    private String dsTimeStart;
    private String dsDateEnd;
    private String dsTimeEnd;
    private String dsAuditorio;
    private String organizador;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_evento_personalizado")
    private Long id;
}
