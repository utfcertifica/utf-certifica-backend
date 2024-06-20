package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.util.List;
import java.util.stream.Collectors;

import com.OficinaDeSoftware.EmissorCertificadosBackend.models.*;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.DateEventRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.EventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.DateEventConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.EventoConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;
    @Autowired
    private EventoConverter converter;
    @Autowired
    private DateEventRepository dateEventRepository;
    @Autowired
    private DateEventConverter dateEventConverter;

    public List<EventoDto> findAllAsDto() {
        return findAll()
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }

    public List<Evento> findAll() {
        return repository.findAll();
    }

    public List<EventoDto> findAllByNrUuidResponsavelAsDto(String nrUuidResponsavel) {
        return repository.findAllByNrUuidResponsavel(nrUuidResponsavel)
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }

    public EventoDto findByIdAsDto(String id) {
        return converter.convertToDto(findById(id));
    }

    public Evento findById(String codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new ObjectNotFoundException("Evento não encontrado"));
    }

    public EventoDto insert(EventoDto eventoDto) {
        Evento event = converter.convertToEntity(eventoDto);

        // Save the event
        Evento newEvent = repository.save(event);

        // Save the DateEvents associated with the event
        List<DateEvent> dateEvents = eventoDto.getDateEvents().stream()
                .map(dto -> {
                    DateEvent dateEvent = dateEventConverter.convertToEntity(dto);
                    dateEvent.setEvento(newEvent);
                    return dateEvent;
                })
                .collect(Collectors.toList());

        dateEventRepository.saveAll(dateEvents);

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
