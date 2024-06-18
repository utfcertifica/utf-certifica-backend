package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import java.util.List;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;


import com.OficinaDeSoftware.EmissorCertificadosBackend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/findAll")
    public List<Usuario> user(){
        return service.findAll();
    }

    // Example 
     @PostMapping( "/create" )
     @ResponseStatus( HttpStatus.CREATED )
        public void save( @RequestBody UserDto user){
         service.save(user);
     }

}
