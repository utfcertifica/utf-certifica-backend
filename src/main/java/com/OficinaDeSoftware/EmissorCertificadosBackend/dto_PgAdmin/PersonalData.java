package com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin;



import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@SequenceGenerator(name = "seq_personal_data", sequenceName = "seq_personal_data", allocationSize = 1, initialValue = 1)
public class PersonalData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_personal_data")
    private Long idPersonalData;

    private String idEvento;

    private String dsInstituicao;

    private String dsLocal;

    // private byte[] logo;

    // private byte[] backgroundImage;
    
}
