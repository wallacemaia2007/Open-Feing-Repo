package br.com.maiawall.application.useCase;

import org.springframework.stereotype.Service;

import br.com.maiawall.domain.entity.Pearson;
import br.com.maiawall.infra.controller.request.CreatePearsonRequestDTO;
import br.com.maiawall.infra.controller.response.PearsonResponseDTO;
import br.com.maiawall.infra.repository.PersonRepo;

@Service
public class CreatePearsonUseCase {

    private final PersonRepo pearsonRepo;

    public CreatePearsonUseCase(PersonRepo pearsonRepo) {
        this.pearsonRepo = pearsonRepo;
    }

    public PearsonResponseDTO execute(CreatePearsonRequestDTO request) {
        var pearson = new Pearson(null, request.name(), request.cep());
        pearsonRepo.save(pearson);
        return PearsonResponseDTO.toResponseDTO(pearson);
    }

}
