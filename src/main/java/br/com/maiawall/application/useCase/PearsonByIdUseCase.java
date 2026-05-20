package br.com.maiawall.application.useCase;

import org.springframework.stereotype.Service;

import br.com.maiawall.infra.controller.response.PearsonResponseDTO;
import br.com.maiawall.infra.repository.PersonRepo;

@Service
public class PearsonByIdUseCase {

    private final PersonRepo pearsonRepo;

    public PearsonByIdUseCase(PersonRepo pearsonRepo) {
        this.pearsonRepo = pearsonRepo;
    }

    public PearsonResponseDTO execute(Long id) {
        var pearson = pearsonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pearson not found with id: " + id));

        return new PearsonResponseDTO(pearson.getId(), pearson.getName(), pearson.getCpf(), pearson.getEmail(), pearson.getCep());
    }

}
