package com.alura.foro.foroHub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistrarUsuarioDTO(
        @NotBlank @Email
        String email,
        @NotBlank @Size(min = 8)
        String clave,
        @NotBlank
        String nombre
) {
}
