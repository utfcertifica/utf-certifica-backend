package com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {
    public Usuario findByEmail( String email);
    public Usuario findBynrUuid(String nrUuid );
}
