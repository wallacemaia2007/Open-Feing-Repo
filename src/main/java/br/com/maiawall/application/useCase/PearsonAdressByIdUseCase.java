package br.com.maiawall.application.useCase;

import org.springframework.stereotype.Service;

import br.com.maiawall.infra.client.ViaCepClient;
import br.com.maiawall.infra.controller.response.AddressResponseDTO;

@Service
public class PearsonAdressByIdUseCase {

    private PearsonByIdUseCase pearsonByIdUseCase;
    private ViaCepClient viaCepClient;

    public PearsonAdressByIdUseCase(PearsonByIdUseCase pearsonByIdUseCase, ViaCepClient viaCepClient) {
        this.pearsonByIdUseCase = pearsonByIdUseCase;
        this.viaCepClient = viaCepClient;
    }

    public AddressResponseDTO execute(Long id) {

        var pearson = pearsonByIdUseCase.execute(id);

        var address = viaCepClient.getAddressByCep(pearson.cep());

        return new AddressResponseDTO(
                address.cep(),
                address.logradouro(),
                address.complemento(),
                address.bairro(),
                address.localidade(),
                address.uf());
    }
}
