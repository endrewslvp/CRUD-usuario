package com.endrew.cadastro_usuario.service;

import com.endrew.cadastro_usuario.infrastructure.entity.Usuario;
import com.endrew.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public List<Usuario> buscarTodosUsuarios () {
        return repository.findAll();
    }

    public Usuario buscarUsuarioPorCpf(String cpf){
        return repository.findByCpf(cpf).orElseThrow(
            () -> new RuntimeException("CPF não encontrado")
        );
    }

    public void deletarUsuarioPorCpf (String cpf){
        repository.deleteByCpf(cpf).orElseThrow(
                () -> new RuntimeException("CPF não encontrado")
        );
    }

    public void atualizarUsuarioPorId (Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
        Usuario usuarioAtualizado = Usuario.builder()
                .id(usuarioEntity.getId())
                .nome(usuario.getNome()!=null?usuario.getNome():usuarioEntity.getNome())
                .cpf(usuario.getCpf()!=null?usuario.getCpf():usuarioEntity.getCpf())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}

