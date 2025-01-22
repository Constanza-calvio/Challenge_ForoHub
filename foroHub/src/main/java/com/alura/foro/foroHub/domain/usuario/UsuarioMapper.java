package com.alura.foro.foroHub.domain.usuario;

import org.mapstruct.Mapper;

@Mapper
public interface UsuarioMapper {
    Usuario usuarioDtoMapper(RegistrarUsuarioDTO usuarioDto);
}
