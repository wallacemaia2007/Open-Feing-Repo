package br.com.maiawall.infra.controller.request;

public record CreatePearsonRequestDTO(String name, String cpf, String email, String cep) {

    public CreatePearsonRequestDTO(Long id, String name, String email, String cpf, String cep) {
        this(name, cpf, email, cep);
    }

}
