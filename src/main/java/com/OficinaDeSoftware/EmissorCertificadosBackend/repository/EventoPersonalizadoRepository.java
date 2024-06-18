package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.models.EventoPersonalizado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoPersonalizadoRepository extends JpaRepository<EventoPersonalizado, String> {
}
