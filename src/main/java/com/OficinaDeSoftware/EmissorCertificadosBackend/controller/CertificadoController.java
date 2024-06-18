package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import java.util.List;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CertificadoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Certificado;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import com.OficinaDeSoftware.EmissorCertificadosBackend.service.CertificadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/certificado")
public class CertificadoController {

    @Autowired
    private CertificadoService service;

    private static final Logger logger = LoggerFactory.getLogger(CertificadoController.class);

    @GetMapping("/{id}")
    public ResponseEntity<Certificado> findOne(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/findAll")
    public List<Certificado> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestPart("certificado") CertificadoDto certificado, @RequestPart("file") MultipartFile file) {
        logger.info("Received certificado: {}", certificado);
        logger.info("Received file: {}", file.getOriginalFilename());

        service.insert(certificado, file);
    }
    @PutMapping(value = "/{idupdate}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("idupdate") Long id, @RequestPart("certificado") CertificadoDto certificado, @RequestPart("file") MultipartFile file) {
        logger.info("Updating certificado with id: {}", id);
        logger.info("Received certificado: {}", certificado);
        logger.info("Received file: {}", file.getOriginalFilename());

        service.atualizar(id, certificado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
