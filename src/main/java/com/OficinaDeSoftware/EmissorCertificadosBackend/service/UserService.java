package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.UserConverter;

import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.UserRepository;
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
        user.setNrUuid(userDto.getNrUuid());
        // user.setRoles(userDto.getRoles());

        repository.save(user);

        return userDto;
    }

    public Usuario findByNrUuid(final String nrUuid) {
        return repository.findByNrUuid(nrUuid)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

}