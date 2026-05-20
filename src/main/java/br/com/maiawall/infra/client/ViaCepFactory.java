package br.com.maiawall.infra.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import br.com.maiawall.application.dto.AdressDTO;
import feign.FeignException;

@Component
public class ViaCepFactory implements FallbackFactory<ViaCepClient> {

    @Override
    public ViaCepClient create(Throwable cause) {

        System.err.println("O Feign falhou pelo seguinte motivo: " + cause.getMessage());

        return new ViaCepClient() {
            @Override
            public AdressDTO getAddressByCep(String cep) {
                if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
                    System.out.println("CEP inexistente na base do ViaCEP.");
                    return new AdressDTO(cep, "CEP Inexistente", "", "", "", "");
                }

                System.out.println("Serviço fora do ar. Aplicando dados genéricos de contingência.");
                return new AdressDTO(cep, "Serviço Indisponível", "UF", "Cidade", "Bairro", "Logradouro");
            };
        };
    };

}
