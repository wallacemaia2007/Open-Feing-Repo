package br.com.maiawall.infra.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.maiawall.application.useCases.AllPearsonsUseCase;
import br.com.maiawall.application.useCases.CreatePearsonUseCase;
import br.com.maiawall.application.useCases.PearsonAdressByIdUseCase;
import br.com.maiawall.application.useCases.PearsonByIdUseCase;
import br.com.maiawall.infra.controller.request.PearsonRequestDTO;
import br.com.maiawall.infra.controller.response.AddressResponseDTO;
import br.com.maiawall.infra.controller.response.PearsonResponseDTO;

@RestController
@RequestMapping("/pearson")
public class PearsonController {

    private AllPearsonsUseCase allPearsonsUseCase;
    private PearsonByIdUseCase pearsonByIdUseCase;
    private PearsonAdressByIdUseCase pearsonAdressByIdUseCase;
    private CreatePearsonUseCase createPearsonUseCase;

    public PearsonController(AllPearsonsUseCase allPearsonsUseCase, PearsonByIdUseCase pearsonByIdUseCase,
            PearsonAdressByIdUseCase pearsonAdressByIdUseCase, CreatePearsonUseCase createPearsonUseCase) {
        this.allPearsonsUseCase = allPearsonsUseCase;
        this.pearsonByIdUseCase = pearsonByIdUseCase;
        this.pearsonAdressByIdUseCase = pearsonAdressByIdUseCase;
        this.createPearsonUseCase = createPearsonUseCase;
    }

    @GetMapping("")
    public ResponseEntity<List<PearsonResponseDTO>> getAllPearson() {
        return ResponseEntity.ok().body(allPearsonsUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PearsonResponseDTO> getPearsonById(@RequestParam Long id) {
        return ResponseEntity.ok().body(pearsonByIdUseCase.execute(id));
    }

    @PostMapping("")
    public ResponseEntity<PearsonResponseDTO> createPearson(@RequestBody PearsonRequestDTO request) {
        return ResponseEntity.ok().body(createPearsonUseCase.execute(request));
    }

    @GetMapping("/{id}/adress")
    public ResponseEntity<AddressResponseDTO> getAdressByPearsonId(@RequestParam Long id) {
        return ResponseEntity.ok().body(pearsonAdressByIdUseCase.execute(id));
    }

}
