package br.com.maiawall.infra.controller.request;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.Email;

public record UpdatePearsonRequestDTO(
        String name,
        @CPF(message = "CPF inválido") String cpf,
        @Email(message = "E-mail inválido") String email,
        String cep) {

    public boolean isEmpty() {
        return (name == null || name.isBlank()) &&
                (cpf == null || cpf.isBlank()) &&
                (email == null || email.isBlank()) &&
                (cep == null || cep.isBlank());
    }
}