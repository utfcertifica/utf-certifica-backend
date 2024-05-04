package com.OficinaDeSoftware.EmissorCertificadosBackend.converter;

import java.util.Objects;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;

@Component
public class UserConverter {

  @Autowired
  private ModelMapper modelMapper;

  public UserDto convertToDto( final ProviderModel provider ){

    return Objects.isNull(provider) ? null : modelMapper.map( provider, UserDto.class );
    
  }

  public UserDto convertToDto( final Usuario user ) {

    return Objects.isNull(user) ? null : modelMapper.map( user, UserDto.class );

  } 

  public Usuario convertToEntity( final UserDto dto ) {

    return Objects.isNull(dto) ? null : modelMapper.map( dto, Usuario.class );
    
  }

}