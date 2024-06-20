package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String dsNome;

    @JsonProperty("dateStart")
    private LocalDate dhInicio;

    @JsonProperty("dateEnd")
    private LocalDate dhFim;

    @JsonProperty("abstract")
    private String dsResumo;

    @JsonProperty("nrUuidResponsavel")
    private String nrUuidResponsavel;

    @JsonProperty("informations")
    private String dsInformacoes;

    @JsonProperty("banner")
    private String dsBanner;

    @JsonProperty("dateEvents")
    private List<DateEventDto> dateEvents; // Lista de cronogramas do evento
}
