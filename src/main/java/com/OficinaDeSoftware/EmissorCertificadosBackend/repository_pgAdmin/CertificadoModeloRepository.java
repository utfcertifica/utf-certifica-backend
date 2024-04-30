package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.CertificadoModelo;

public interface CertificadoModeloRepository extends MongoRepository<CertificadoModelo, String> {}
