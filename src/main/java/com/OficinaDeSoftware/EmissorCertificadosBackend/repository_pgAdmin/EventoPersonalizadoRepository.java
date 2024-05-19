package com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.EventoPersonalizado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoPersonalizadoRepository extends JpaRepository<EventoPersonalizado, String> {
}
