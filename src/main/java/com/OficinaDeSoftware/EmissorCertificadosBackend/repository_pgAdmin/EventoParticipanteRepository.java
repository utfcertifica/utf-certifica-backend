package com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin;

import java.util.List;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.EventoParticipante;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoParticipanteRepository extends JpaRepository<EventoParticipante, String> {
    public boolean existsByNrUuidParticipanteAndIdEvento( String nrUuidParticipante, String idEvento );
    public List<EventoParticipante> findAllByIdEvento( String idEvento );
    public void deleteByIdEventoAndNrUuidParticipante( String idEvento, String nrUuidParticipante );
}

