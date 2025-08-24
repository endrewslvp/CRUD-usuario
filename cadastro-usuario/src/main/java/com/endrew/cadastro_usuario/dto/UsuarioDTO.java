package com.endrew.cadastro_usuario.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioDTO(

        @NotBlank
        String nome,

        @NotBlank
        @CPF
        String cpf
) {
}
