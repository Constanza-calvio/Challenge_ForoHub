package com.alura.foro.foroHub.controller;

import com.alura.foro.foroHub.domain.usuario.Usuario;
import com.alura.foro.foroHub.domain.usuario.UsuarioAutenticacionDTO;
import com.alura.foro.foroHub.infra.security.JWTTokenDTO;
import com.alura.foro.foroHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioAutenticacionDTO usuarioAutenticacionDTO) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuarioAutenticacionDTO.login(),
                usuarioAutenticacionDTO.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new JWTTokenDTO(JWTtoken));
    }
}
