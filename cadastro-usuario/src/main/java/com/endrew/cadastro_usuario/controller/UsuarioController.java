package com.endrew.cadastro_usuario.controller;

import com.endrew.cadastro_usuario.infrastructure.entity.Usuario;
import com.endrew.cadastro_usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public void salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
    }

    @GetMapping
    public Usuario buscarUsuarioPorCpf(@RequestParam String cpf){
        return usuarioService.buscarUsuarioPorCpf(cpf);
    }

    @GetMapping("all")
    public List<Usuario> buscarTodosUsuarios(){
        return usuarioService.buscarTodosUsuarios();
    }

    @DeleteMapping
    public void deletarUsuarioPorCpf (@RequestParam String cpf){
        usuarioService.deletarUsuarioPorCpf(cpf);
    }

    @PutMapping
    public void atualizarUsuarioPorId(@RequestParam Integer id, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioPorId(id,usuario);
    }
}
