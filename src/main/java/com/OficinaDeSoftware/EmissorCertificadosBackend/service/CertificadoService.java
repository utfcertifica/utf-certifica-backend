package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.CertificadoConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.models.Certificado;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CertificadoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.CertificadoRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CertificadoService {

    @Autowired
    private CertificadoRepository repository;

    @Autowired
    private CertificadoConverter converter;

    private final Path fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();
    private static final Logger logger = LoggerFactory.getLogger(CertificadoService.class);

    public CertificadoService() {
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public List<Certificado> findAll() {
        return repository.findAll();
    }

    public Certificado findById(Long codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new ObjectNotFoundException("Certificate not found"));
    }

    public Certificado insert(CertificadoDto certificadoDto, MultipartFile file) {
        logger.info("Inserting certificado: {}", certificadoDto);
        logger.info("File details: Name - {}, Size - {}", file.getOriginalFilename(), file.getSize());

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String newFileName = resolveFileNameConflict(fileName);

        try {
            Path targetLocation = this.fileStorageLocation.resolve(newFileName);
            Files.copy(file.getInputStream(), targetLocation);

            certificadoDto.setFileCertificado(targetLocation.toString());

            Certificado certificado = converter.convertToEntity(certificadoDto);
            return repository.save(certificado);
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    private String resolveFileNameConflict(String fileName) {
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        int count = 1;

        String newFileName = fileName;
        while (Files.exists(this.fileStorageLocation.resolve(newFileName))) {
            newFileName = baseName + "_" + count + extension;
            count++;
        }

        return newFileName;
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public Certificado atualizar(Long id, CertificadoDto certificadoDto) {
        logger.info("Atualizando certificado com id: {}", id);
        logger.info("Certificado recebido: {}", certificadoDto);
        // Encontrar o certificado existente
        Optional<Certificado> optionalCertificado = repository.findById(id);
        if (!optionalCertificado.isPresent()) {
            throw new RuntimeException("Certificado não encontrado com id " + id);
        }

        Certificado certificadoExistente = optionalCertificado.get();

        // Atualizar campos do certificado com os dados do DTO
        certificadoExistente.setIdEvento(certificadoDto.getIdEvento());
        certificadoExistente.setNomeEvento(certificadoDto.getNomeEvento());
        certificadoExistente.setMinistrante(certificadoDto.getMinistrante());
        certificadoExistente.setDataEvento(certificadoDto.getDataEvento());
        certificadoExistente.setNrCargaHoraria(certificadoDto.getNrCargaHoraria());
        certificadoExistente.setFileCertificado(certificadoDto.getFileCertificado());
        certificadoExistente.setIdCertificadoModelo(certificadoDto.getIdCertificadoModelo());

        // Salvar o certificado atualizado
        return repository.save(certificadoExistente);
    }
}
