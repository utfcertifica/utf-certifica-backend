package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificadoDto {

    @Id
    @JsonIgnore
    private String id;
    
    @JsonProperty("idEvento")
    private Long idEvento;

    @JsonProperty("nomeEvento")
    private String nomeEvento;

    @JsonProperty("ministrante")
    private String ministrante;

    @JsonProperty("dataEvento")
    private LocalDate dataEvento;

    @JsonProperty("nrCargaHoraria")
    private Integer nrCargaHoraria;

    @JsonProperty("fileCertificado")
    private String fileCertificado;

    @JsonProperty("idCertificadoModelo")
    private String idCertificadoModelo;
}
