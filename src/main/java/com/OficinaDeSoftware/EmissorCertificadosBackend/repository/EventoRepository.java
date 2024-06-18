package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import java.util.List;

import com.OficinaDeSoftware.EmissorCertificadosBackend.models.Evento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, String> {
    List<Evento> findAllByNrUuidResponsavel(String nrUuidResponsavel );
}

