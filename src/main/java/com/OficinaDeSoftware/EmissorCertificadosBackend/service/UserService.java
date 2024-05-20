package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public void save(final UserDto user) {
        this.repository.save(userConverter.convertToEntity(user));
    }

    public UserDto createOrUpdateUser(UserDto userDto) {
        Usuario user = repository.findByEmail(userDto.getEmail());
        if (user == null) {
            user = new Usuario();
            user.setEmail(userDto.getEmail());
        }

        user.setName(userDto.getName());
        // user.setRoles(userDto.getRoles());

        Usuario savedUser = repository.save(user);
        if (savedUser != null && savedUser.getNrUuid() != null) {
            userDto.setNrUuid(savedUser.getNrUuid().toString()); // Assuming nrUuid is user ID
        }

        return userDto;
    }

    public Usuario findByNrUuid(final String nrUuid) {
        return repository.findByNrUuid(nrUuid)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }
    
}