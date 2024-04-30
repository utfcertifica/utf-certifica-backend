package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.CertificadoModeloConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.CertificadoModelo;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CertificadoModeloDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin.CertificadoModeloRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@Service
public class CertificadoModeloService {
    
    @Autowired
    private CertificadoModeloRepository repository;

    @Autowired
    private CertificadoModeloConverter converter;

    public List<CertificadoModelo> findAll() {
        return repository.findAll();
    }

    public CertificadoModelo findById(Long codigo) {
        return repository.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("CertificadoModelo não encontrado"));
    }

    public CertificadoModelo insert(CertificadoModeloDto certificadoModelo) {
        return repository.save(converter.convertToEntity(certificadoModelo));
    }

    public CertificadoModelo update(CertificadoModeloDto certificadoModelo) {
        CertificadoModelo certificadoModeloAtualizado = findById(certificadoModelo.getIdCertificadoModelo());
        BeanUtils.copyProperties(certificadoModelo, certificadoModeloAtualizado);
        return repository.save(certificadoModeloAtualizado);
    }

    public void delete(Long codigo) {
        findById(codigo);
        repository.deleteById(codigo);
    }
}
