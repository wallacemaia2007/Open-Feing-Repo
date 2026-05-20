package br.com.maiawall.infra.controller.response;

public record AddressResponseDTO(String logradouro, String bairro, String localidade, String estado, String cep) {

    public AddressResponseDTO(String cep, String logradouro, String complemento, String bairro, String localidade,
            String uf) {
        this(logradouro, bairro, localidade, uf, cep);
    }

}
