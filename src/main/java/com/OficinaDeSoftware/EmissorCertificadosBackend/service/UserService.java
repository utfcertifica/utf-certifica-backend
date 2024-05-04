package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.UserConverter;


import com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin.UserRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserConverter userConverter;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public void save(final Usuario user) {
        this.repository.save(user);
    }

    //public Usuario findByNrUuid(final String nrUuid) {
      //  return repository.findByUuid(nrUuid).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
   // }
    
}