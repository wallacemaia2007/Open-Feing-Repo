package br.com.maiawall.infra.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.maiawall.application.useCases.*;
import br.com.maiawall.infra.controller.request.PearsonRequestDTO;
import br.com.maiawall.infra.controller.request.UpdatePearsonRequestDTO;
import br.com.maiawall.infra.controller.response.AddressResponseDTO;
import br.com.maiawall.infra.controller.response.PearsonResponseDTO;

@RestController
@RequestMapping("/pearson")
public class PearsonController {

    private AllPearsonsUseCase allPearsonsUseCase;
    private PearsonByIdUseCase pearsonByIdUseCase;
    private PearsonAdressByIdUseCase pearsonAdressByIdUseCase;
    private CreatePearsonUseCase createPearsonUseCase;
    private DeletePearsonUseCase deletePearsonUseCase;
    private UpdatePearsonUseCase updatePearsonUseCase;

    public PearsonController(AllPearsonsUseCase allPearsonsUseCase, PearsonByIdUseCase pearsonByIdUseCase,
            PearsonAdressByIdUseCase pearsonAdressByIdUseCase, CreatePearsonUseCase createPearsonUseCase,
            UpdatePearsonUseCase updatePearsonUseCase, DeletePearsonUseCase deletePearsonUseCase) {
        this.allPearsonsUseCase = allPearsonsUseCase;
        this.pearsonByIdUseCase = pearsonByIdUseCase;
        this.pearsonAdressByIdUseCase = pearsonAdressByIdUseCase;
        this.createPearsonUseCase = createPearsonUseCase;
        this.updatePearsonUseCase = updatePearsonUseCase;
        this.deletePearsonUseCase = deletePearsonUseCase;
    }

    @GetMapping("")
    public ResponseEntity<List<PearsonResponseDTO>> getAllPearson() {
        return ResponseEntity.ok().body(allPearsonsUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PearsonResponseDTO> getPearsonById(@PathVariable Long id) {
        return ResponseEntity.ok().body(pearsonByIdUseCase.execute(id));
    }

    @PostMapping("")
    public ResponseEntity<PearsonResponseDTO> createPearson(@RequestBody PearsonRequestDTO request) {
        return ResponseEntity.ok().body(createPearsonUseCase.execute(request));
    }

    @GetMapping("/{id}/adress")
    public ResponseEntity<AddressResponseDTO> getAdressByPearsonId(@PathVariable Long id) {
        return ResponseEntity.ok().body(pearsonAdressByIdUseCase.execute(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PearsonResponseDTO> updatePearson(
            @RequestBody UpdatePearsonRequestDTO updatePearsonRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok().body(updatePearsonUseCase.execute(updatePearsonRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePearson(@PathVariable Long id) {
        deletePearsonUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
