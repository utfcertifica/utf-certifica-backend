package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrendetialDto {
    
    @NotNull
    private String username;
    private String password;
}
