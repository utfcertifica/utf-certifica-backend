package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.models.Certificado;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {}