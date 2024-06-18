package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDto {
    
    @Id
    @JsonIgnore
    private String id;
    
    @JsonProperty("name")
    private String dsNome;

    @JsonProperty("dateStart")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dhInicio;

    @JsonProperty("dateEnd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dhFim;

    @JsonProperty("abstract")
    private String dsResumo;

    @JsonProperty("informations")
    private String dsInformacoes;

    @JsonProperty("banner")
    private String dsBanner;
}

