package com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin;


import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.EventoCheckin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoCheckinRepository extends JpaRepository<EventoCheckin, String> {}

