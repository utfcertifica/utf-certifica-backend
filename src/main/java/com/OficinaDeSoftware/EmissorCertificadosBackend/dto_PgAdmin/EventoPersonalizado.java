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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_evento_personalizado")
    private Long id;

    public EventoPersonalizado(String dsNome, String dsInformacoes, String format, String format1, String format2, String format3, String loc, String org, Long id) {
    }
}
