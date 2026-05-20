package br.com.maiawall.infra.controller.request;

import java.util.Optional;

public record UpdatePearsonRequestDTO(Optional<String> name, Optional<String> cep) {

}
