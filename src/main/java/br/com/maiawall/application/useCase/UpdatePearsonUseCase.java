package br.com.maiawall.application.useCase;

import org.springframework.stereotype.Service;

import br.com.maiawall.infra.controller.request.UpdatePearsonRequestDTO;
import br.com.maiawall.infra.controller.response.PearsonResponseDTO;
import br.com.maiawall.infra.repository.PersonRepo;

@Service
public class UpdatePearsonUseCase {

    private final PersonRepo pearsonRepo;

    public UpdatePearsonUseCase(PersonRepo pearsonRepo) {
        this.pearsonRepo = pearsonRepo;
    }

    public PearsonResponseDTO execute(UpdatePearsonRequestDTO updatePearsonRequestDTO, Long id) {
        var pearson = pearsonRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pearson not found"));
        if (updatePearsonRequestDTO.isEmpty()) {
            throw new RuntimeException("No data to update");
        }
        if (updatePearsonRequestDTO.name() != null && !updatePearsonRequestDTO.name().isEmpty()) {
            pearson.setName(updatePearsonRequestDTO.name());
        }
        if (updatePearsonRequestDTO.cep() != null && !updatePearsonRequestDTO.cep().isEmpty()) {
            pearson.setCep(updatePearsonRequestDTO.cep());
        }
        if (updatePearsonRequestDTO.cpf() != null && !updatePearsonRequestDTO.cpf().isEmpty()) {
            pearson.setCpf(updatePearsonRequestDTO.cpf());
        }
        if (updatePearsonRequestDTO.email() != null && !updatePearsonRequestDTO.email().isEmpty()) {
            pearson.setEmail(updatePearsonRequestDTO.email());
        }
        pearsonRepo.save(pearson);

        return new PearsonResponseDTO(pearson.getId(), pearson.getName(), pearson.getCpf(), pearson.getEmail(),
                pearson.getCep());
    }

}
