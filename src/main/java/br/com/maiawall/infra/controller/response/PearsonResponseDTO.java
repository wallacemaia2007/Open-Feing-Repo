package br.com.maiawall.infra.controller.response;

import br.com.maiawall.domain.entity.Pearson;

public record PearsonResponseDTO(Long id, String name, String cep) {

    public static PearsonResponseDTO toResponseDTO(Pearson pearson) {
        return new PearsonResponseDTO(pearson.getId(), pearson.getName(), pearson.getCep());
    }

}
