package com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin;

import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Data
@SequenceGenerator(name = "seq_certificado_modelo", sequenceName = "seq_certificado_modelo", allocationSize = 1, initialValue = 1)
@Entity
public class CertificadoModelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_certificado_modelo")
    private Long idCertificadoModelo;
    private String xmlModelo;
}
