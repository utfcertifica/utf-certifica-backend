package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import java.util.List;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    // @PostMapping( "/create" )
    // @ResponseStatus( HttpStatus.CREATED )
    // public void save( @RequestBody User user ){
    //     service.save( user );
    // }

}
