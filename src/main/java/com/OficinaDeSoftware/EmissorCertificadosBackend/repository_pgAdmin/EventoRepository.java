package com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin;

import java.util.List;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Evento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, String> {
    List<Evento> findAllByNrUuidResponsavel(String nrUuidResponsavel );
}

