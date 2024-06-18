package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.models.CertificadoModelo;

public interface CertificadoModeloRepository extends JpaRepository<CertificadoModelo, Long> {}
