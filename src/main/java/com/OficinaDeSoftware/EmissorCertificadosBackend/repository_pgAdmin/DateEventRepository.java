package com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.DateEvent;

public interface DateEventRepository extends JpaRepository<DateEvent, Long> {}
