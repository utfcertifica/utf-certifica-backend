package com.OficinaDeSoftware.EmissorCertificadosBackend.controller.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
