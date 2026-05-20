package br.com.maiawall.domain.entity;

public record Adress(
        String logradouro,
        String bairro,
        String localidade,
        String estado,
        String cep) {

}
