package com.OficinaDeSoftware.EmissorCertificadosBackend.converter;

import java.util.Objects;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Evento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;

@Component
public class EventoConverter {

  @Autowired
  private ModelMapper modelMapper;

  public EventoDto convertToDto( final ProviderModel provider ){

    return Objects.isNull(provider) ? null : modelMapper.map( provider, EventoDto.class );
    
  }

  public EventoDto convertToDto( final Evento user ) {

    return Objects.isNull(user) ? null : modelMapper.map( user, EventoDto.class );

  } 

  public Evento convertToEntity( final EventoDto dto ) {

    return Objects.isNull(dto) ? null : modelMapper.map( dto, Evento.class );
    
  }

}