package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.*;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin.EventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.EventoConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin.CertificadoRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin.DateEventRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;
    @Autowired
    private EventoConverter converter;
    
    public List<EventoDto> findAllAsDto() {
        return findAll()
                .stream()
                .map(current -> converter.convertToDto(current))
                .collect(Collectors.toList());
    }

    public List<Evento> findAll() {
        return repository.findAll();
    }

    public List<EventoDto> findAllByNrUuidResponsavelAsDto(String nrUuidResponsavel) {
        return repository.findAllByNrUuidResponsavel(nrUuidResponsavel)
                .stream()
                .map(current -> converter.convertToDto(current))
                .collect(Collectors.toList());
    }

    public EventoDto findByIdAsDto(String id) {
        return converter.convertToDto(findById(id));
    }

    public Evento findById(String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new ObjectNotFoundException("Evento não encontrado"));

    }

    public EventoDto insert(EventoDto evento) {
        Evento event = converter.convertToEntity(evento);

        Evento newEvent = repository.save(event);

        return converter.convertToDto(newEvent);
    }

    public Evento update(EventoDto evento) {
        Evento eventoAtualizado = findById(evento.getId());
        BeanUtils.copyProperties(evento, eventoAtualizado);
        return repository.save(eventoAtualizado);
    }

    public void delete(String codigo) {
        findById(codigo);
        repository.deleteById(codigo);
    }
}
