package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.models.DateEvent;

public interface DateEventRepository extends JpaRepository<DateEvent, Long> {}
