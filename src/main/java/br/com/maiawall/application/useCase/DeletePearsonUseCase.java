package br.com.maiawall.application.useCase;

import org.springframework.stereotype.Service;

import br.com.maiawall.infra.repository.PersonRepo;

@Service
public class DeletePearsonUseCase {

    private final PersonRepo pearsonRepo;

    public DeletePearsonUseCase(PersonRepo pearsonRepo) {
        this.pearsonRepo = pearsonRepo;
    }

    public void execute(Long id) {
        pearsonRepo.deleteById(id);
    }

}
