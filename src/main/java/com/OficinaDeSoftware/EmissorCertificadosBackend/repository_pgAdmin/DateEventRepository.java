package com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.DateEvent;

public interface DateEventRepository extends JpaRepository<DateEvent, Long> {}
