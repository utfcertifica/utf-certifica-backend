package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import java.util.List;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CertificadoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Certificado;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.OficinaDeSoftware.EmissorCertificadosBackend.service.CertificadoService;

@RestController
@RequestMapping("/api/certificado")
public class CertificadoController {

    @Autowired
    private CertificadoService service;

    @GetMapping("/findAll")
    public List<Certificado> user() {
        return service.findAll();
    }

    // Example
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CertificadoDto certificado) {
        service.insert(certificado);
    }

}
