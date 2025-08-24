package com.endrew.cadastro_usuario.infrastructure.entity;

import com.endrew.cadastro_usuario.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "usuario")
@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "CPF", unique = true)
    private String cpf;

    public Usuario(UsuarioDTO usuario) {
        this.nome = usuario.nome();
        this.cpf = usuario.cpf();
    }
}
