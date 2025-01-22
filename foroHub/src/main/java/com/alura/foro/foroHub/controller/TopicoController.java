package com.alura.foro.foroHub.controller;

import com.alura.foro.foroHub.domain.topic.Topico;
import com.alura.foro.foroHub.domain.topic.TopicoRepository;
import com.alura.foro.foroHub.domain.usuario.Usuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {
    @Autowired
    TopicoRepository topicRepo;
    @Autowired
    Topico topic;

    @PostMapping
    @Transactional
    public void registrarTopico(@RequestBody @Valid Topico topic) {
       topicRepo.save(new Topico());
    }




}
