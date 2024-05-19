package com.OficinaDeSoftware.EmissorCertificadosBackend.converter;

import java.util.Objects;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.EventoParticipante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoParticipanteDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;

@Component
public class EventoParticipanteConverter {

  @Autowired
  private ModelMapper modelMapper;

  public EventoParticipanteDto convertToDto( final ProviderModel provider ){

    return Objects.isNull(provider) ? null : modelMapper.map( provider, EventoParticipanteDto.class );
    
  }

  public EventoParticipanteDto convertToDto( final EventoParticipante user ) {

    return Objects.isNull(user) ? null : modelMapper.map( user, EventoParticipanteDto.class );

  } 

  public EventoParticipante convertToEntity( final EventoParticipanteDto dto ) {

    return Objects.isNull(dto) ? null : modelMapper.map( dto, EventoParticipante.class );
    
  }

}