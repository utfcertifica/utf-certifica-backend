package com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin;

import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class Usuario  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long idUsuario;

    private String nrUuid; //ra
    private String name;
    private String email;
    private String urlImagemPerfil;
    private Integer tipoUsuario;

    //@Enumerated(EnumType.STRING)
    //private List<RoleEnum> roles;
}