package br.com.maiawall.infra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.maiawall.application.dto.AdressDTO;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws", fallbackFactory = ViaCepFactory.class)
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    AdressDTO getAddressByCep(@PathVariable("cep") String cep);
}