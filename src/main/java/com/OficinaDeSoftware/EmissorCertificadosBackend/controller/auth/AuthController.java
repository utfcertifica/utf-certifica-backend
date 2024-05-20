package com.OficinaDeSoftware.EmissorCertificadosBackend.controller.auth;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CrendetialDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.ErrorDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.ProfileDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.UserService;
import com.OficinaDeSoftware.EmissorCertificadosBackend.util.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Tag(name = "Auth")
@RequestMapping(value = "/api/auth", produces = {"application/json"})
public class AuthController {


    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    // @Autowired
    // private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    private static final String AUTH_URL = "https://coensapp.dv.utfpr.edu.br/siacoes/service/login";
    private static final String PROFILE_URL = "https://coensapp.dv.utfpr.edu.br/siacoes/service/user/profile";

    @Operation(summary = "Realiza a autenticação do usuario", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario autenticado com sucesso!", content = {@Content(schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "401", description = "Acesso não autorizado!", content = {@Content(schema = @Schema(implementation = ErrorDto.class))})
    })

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody CrendetialDto crendetialDto) {
        try {

            logger.info("Iniciando signIn...");

            // Autenticar na API externa do siacoes
            logger.info("Fazendo requisição de autenticação para: {}", AUTH_URL);            
            RestTemplate restTemplate = new RestTemplate();
            Map<String, String> authRequest = new HashMap<>();
            authRequest.put("login", crendetialDto.getUsername());
            authRequest.put("password", crendetialDto.getPassword());

            logger.info("authRequest dados : {}", authRequest);

            ResponseEntity<String> authResponse = restTemplate.postForEntity(AUTH_URL, authRequest, String.class);
            logger.info("Resposta da requisição de autenticação recebida com status: {}", authResponse.getStatusCode());

            if (authResponse.getStatusCode().is2xxSuccessful()) {
                String externalToken = authResponse.getBody();

                logger.info("Token externo recebido: {}", externalToken);

                // Obter dados do usuário
                HttpHeaders headers = new HttpHeaders();
                headers.setBearerAuth(externalToken);
                HttpEntity<String> entity = new HttpEntity<>(headers);

                logger.info("Fazendo requisição de perfil do usuário para: {}", PROFILE_URL);
                ResponseEntity<ProfileDto> profileResponse = restTemplate.exchange(PROFILE_URL, HttpMethod.GET, entity, ProfileDto.class);
                logger.info("Resposta da requisição de perfil do usuário recebida com status: {}", profileResponse.getStatusCode());

                if (profileResponse.getStatusCode().is2xxSuccessful()) {
                    ProfileDto profileDto = profileResponse.getBody();
                    logger.info("Dados do perfil do usuário recebidos: {}", profileDto);

                    UserDto userDto = new UserDto();
                    userDto.setNrUuid(profileDto.getLogin());
                    userDto.setName(profileDto.getName());
                    userDto.setEmail(profileDto.getEmail());
                    userDto.setUrlImagemPerfil(profileDto.getPhoto());

                    // Criar ou atualizar o usuário no sistema local
                    UserDto localUser = userService.createOrUpdateUser(userDto);

                    // Gerar token JWT local e retornar
                    final String jwt = jwtUtil.generateToken(localUser);
                    localUser.setAccessToken(jwt);

                    logger.info("Usuário autenticado com sucesso!");
                    return ResponseEntity.ok(localUser);
                } else {
                    logger.error("Falha ao obter perfil do usuário! Status: {}", profileResponse.getStatusCode());
                    return ResponseEntity.status(profileResponse.getStatusCode()).body(new ErrorDto("Falha ao obter perfil do usuário!"));
                }
            } else {
                logger.error("Acesso não autorizado! Status: {}", authResponse.getStatusCode());
                return ResponseEntity.status(authResponse.getStatusCode()).body(new ErrorDto("Acesso não autorizadss!"));
            }
        } catch (Exception e) {
            logger.error("Erro durante o signIn: {}", e.getMessage());
            return ResponseEntity.status(401).body(new ErrorDto("Acesso não autorizado!"));
        }
    }
}
