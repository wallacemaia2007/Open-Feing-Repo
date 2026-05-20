package br.com.maiawall.application.useCases;

import org.springframework.stereotype.Service;

import br.com.maiawall.infra.controller.request.UpdatePearsonRequestDTO;
import br.com.maiawall.infra.controller.response.PearsonResponseDTO;
import br.com.maiawall.infra.repo.PersonRepo;

@Service
public class UpdatePearsonUseCase {

    private final PersonRepo pearsonRepo;

    public UpdatePearsonUseCase(PersonRepo pearsonRepo) {
        this.pearsonRepo = pearsonRepo;
    }

    public PearsonResponseDTO execute(UpdatePearsonRequestDTO updatePearsonRequestDTO, Long id) {
        var pearson = pearsonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pearson not found"));
        if (updatePearsonRequestDTO.name().isEmpty() && updatePearsonRequestDTO.cep().isEmpty()) {
            throw new RuntimeException("No data to update");
        }
        if (updatePearsonRequestDTO.name().isPresent()) {
            pearson.setName(updatePearsonRequestDTO.name().get());
        }
        if (updatePearsonRequestDTO.cep().isPresent()) {
            pearson.setCep(updatePearsonRequestDTO.cep().get());
        }
        pearsonRepo.save(pearson);

        return new PearsonResponseDTO(pearson.getId(), pearson.getName(), pearson.getCep());
    }

}
