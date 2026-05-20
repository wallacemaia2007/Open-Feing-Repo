package br.com.maiawall.application.useCase;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.maiawall.infra.controller.response.PearsonResponseDTO;
import br.com.maiawall.infra.repository.PersonRepo;

@Service
public class AllPearsonsUseCase {

    private final PersonRepo pearsonRepo;

    public AllPearsonsUseCase(PersonRepo pearsonRepo) {
        this.pearsonRepo = pearsonRepo;
    }

    public List<PearsonResponseDTO> execute() {
        return pearsonRepo.findAll().stream()
                .map(pearson -> new PearsonResponseDTO(pearson.getId(), pearson.getName(), pearson.getCpf(), pearson.getEmail(), pearson.getCep()))
                .toList();

    }

}
