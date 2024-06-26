package com.OficinaDeSoftware.EmissorCertificadosBackend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@SequenceGenerator(name = "seq_dateEvent", sequenceName = "seq_dateEvent", allocationSize = 1, initialValue = 1)
public class DateEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private String ministrante;
    private String titulo;
    private LocalDate date;
    private String startTime;
    private String endTime;
}
