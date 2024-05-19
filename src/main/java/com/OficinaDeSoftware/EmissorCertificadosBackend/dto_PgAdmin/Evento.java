package com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_evento", sequenceName = "seq_evento", allocationSize = 1, initialValue = 1)
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_evento")
    private String idEvento;

    private String dsNome;
    private LocalDateTime dhInicio;
    private LocalDateTime dhFim;
    private Integer nrCargaHoraria;
    private String dsInformacoes;
    private String nrUuidResponsavel;

    private Long idLocal;


    //@OneToMany(mappedBy = "usuario")
   // private List<Usuario> participantes;

   // @OneToMany(mappedBy = "date")
   // private List<DateEvent> dates;

   @ManyToOne
   private Certificado certificado;

}