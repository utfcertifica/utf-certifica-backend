package com.OficinaDeSoftware.EmissorCertificadosBackend.converter;

import java.util.Objects;

import com.OficinaDeSoftware.EmissorCertificadosBackend.models.DateEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.DateEventDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.enums.ProviderModel;

@Component
public class DateEventConverter {

  @Autowired
  private ModelMapper modelMapper;

  public DateEventDto convertToDto(final ProviderModel provider) {

    return Objects.isNull(provider) ? null : modelMapper.map(provider, DateEventDto.class);

  }

  public DateEventDto convertToDto(final DateEvent date) {

    return Objects.isNull(date) ? null : modelMapper.map(date, DateEventDto.class);

  }

  public DateEvent convertToEntity(final DateEventDto dto) {

    return Objects.isNull(dto) ? null : modelMapper.map(dto, DateEvent.class);

  }

}