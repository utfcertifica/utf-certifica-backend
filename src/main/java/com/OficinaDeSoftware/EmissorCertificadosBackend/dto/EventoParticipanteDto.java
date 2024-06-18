package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoParticipanteDto {

    @Id
    @JsonIgnore
    private String id;

    @JsonProperty("idEvento")
    private String idEvento;

    @JsonProperty("email")
    private String dsEmail;

    @JsonProperty("name")
    private String dsName;
}
