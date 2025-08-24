package com.endrew.cadastro_usuario.infrastructure.repository;

import com.endrew.cadastro_usuario.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCpf (String cpf);

    @Transactional
    Optional<Usuario> deleteByCpf (String cpf);
}
