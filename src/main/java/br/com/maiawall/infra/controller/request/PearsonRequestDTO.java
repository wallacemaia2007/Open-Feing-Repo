package br.com.maiawall.infra.controller.request;

public record PearsonRequestDTO(String name, String cep) {

    public PearsonRequestDTO(Long id, String name, String cep) {
        this(name, cep);
    }

}
