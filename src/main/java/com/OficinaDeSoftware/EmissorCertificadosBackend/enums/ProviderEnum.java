package com.OficinaDeSoftware.EmissorCertificadosBackend.enums;

public enum ProviderEnum {
    GOOGLE;

    public static ProviderEnum parse(String name) {
        return valueOf(name.toUpperCase());
    }
}