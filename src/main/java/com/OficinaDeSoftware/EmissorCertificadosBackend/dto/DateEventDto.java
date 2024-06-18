package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DateEventDto implements Serializable {

    @JsonIgnore
    @Id
    private String id;

    @JsonIgnore
    private String idEvento;

    private String ministrante;
    private LocalDate date;
    private String startTime;
    private String endTime;
}