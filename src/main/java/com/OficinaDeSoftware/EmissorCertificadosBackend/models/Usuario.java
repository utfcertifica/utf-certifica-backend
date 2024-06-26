package com.OficinaDeSoftware.EmissorCertificadosBackend.models;

import com.OficinaDeSoftware.EmissorCertificadosBackend.enums.RoleEnum;
import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Data
@Entity
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class Usuario  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long idUsuario;

    private String nrUuid; //ra
    private String name;
    private String email;
    private String urlImagemPerfil;
    private Integer tipoUsuario;


    @Enumerated(EnumType.STRING)
    private List<RoleEnum> roles;

    
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return roles.stream()
    //             .map(role -> new SimpleGrantedAuthority(role.name()))
    //             .collect(Collectors.toList());
    // }
    
    // Adicionar senha para autenticação
    private String password;
}
