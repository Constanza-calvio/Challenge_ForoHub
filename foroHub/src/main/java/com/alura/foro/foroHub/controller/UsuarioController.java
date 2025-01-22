package com.alura.foro.foroHub.controller;
import com.alura.foro.foroHub.domain.usuario.RegistrarUsuarioDTO;
import com.alura.foro.foroHub.domain.usuario.Usuario;
import com.alura.foro.foroHub.domain.usuario.UsuarioMapper;
import com.alura.foro.foroHub.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registrar")
@SecurityRequirement(name = "bearer-key")

public class UsuarioController {
    @Autowired
    UsuarioRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioMapper usuarioMapper;


    @PostMapping
    public ResponseEntity<String> registrarUsuario(@RequestBody @Valid RegistrarUsuarioDTO usuarioDTO) {
        // Mapear el DTO a la entidad Usuario
        Usuario nuevoUsuario = usuarioMapper.usuarioDtoMapper(usuarioDTO);

        // Encriptar la contraseña
        String encodedPassword = passwordEncoder.encode(usuarioDTO.clave());
        nuevoUsuario.setClave(encodedPassword);

        // Guardar el usuario en la base de datos
        userRepo.save(nuevoUsuario);

        return ResponseEntity.ok("Usuario registrado exitosamente");
    }















    @DeleteMapping("/{id}")
    @Transactional
    public void eliminar(@PathVariable Long id) {
        var usuario= userRepo.getReferenceById(id);
       usuario.eliminar();
    }
}
