package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.EventoService;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.FileStorageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private EventoService service;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/{id}")
    public ResponseEntity<EventoDto> findOne(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findByIdAsDto(id));
    }

    @GetMapping("/findAll/{nrUuidResponsavel}")
    public ResponseEntity<List<EventoDto>> findAllByNrUuidResponsavel(@PathVariable String nrUuidResponsavel) {
        return ResponseEntity.ok().body(service.findAllByNrUuidResponsavelAsDto(nrUuidResponsavel));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<EventoDto>> findAll() {
        return ResponseEntity.ok().body(service.findAllAsDto());
    }

    @PostMapping
    public ResponseEntity<EventoDto> insert(
            @RequestPart("event") String eventString,
            @RequestPart("file") MultipartFile file) throws JsonProcessingException {

        // Deserializar o JSON do evento
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        EventoDto event = objectMapper.readValue(eventString, EventoDto.class);

        // Armazenar o arquivo e configurar a URL do banner no DTO
        String fileName = fileStorageService.storeFile(file);
        event.setDsBanner(fileName);

        // Inserir o evento
        EventoDto createdEvent = service.insert(event);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    // @PostMapping("/uploadBanner")
    // public ResponseEntity<String> uploadBanner(@RequestParam("file")
    // MultipartFile file) {
    // String fileName = fileStorageService.storeFile(file);
    // return ResponseEntity.status(HttpStatus.OK).body(fileName);
    // }
}
