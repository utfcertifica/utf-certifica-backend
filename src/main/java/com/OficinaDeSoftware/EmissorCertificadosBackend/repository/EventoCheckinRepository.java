package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;


import com.OficinaDeSoftware.EmissorCertificadosBackend.models.EventoCheckin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoCheckinRepository extends JpaRepository<EventoCheckin, String> {}

