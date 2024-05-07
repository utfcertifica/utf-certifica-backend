package com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@SequenceGenerator(name = "seq_dateEvent", sequenceName = "seq_dateEvent", allocationSize = 1, initialValue = 1)

public class DateEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dateEvent")
    private String idDateEvent;
    private String idEvento;
    private String date;
    private String startTime;
    private String endTime;
}
