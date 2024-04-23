package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document( collection = "eventoparticipante" )
public class EventoParticipante {
    
    @Id
    private String idEventoUsuario;
    private String idEvento;
    private String nrUuidParticipante;

    @Transient
    private String dsEmail;
}
