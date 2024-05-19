package com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.CertificadoModelo;

public interface CertificadoModeloRepository extends JpaRepository<CertificadoModelo, Long> {}
