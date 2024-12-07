package be.labil.rest.controllers;

import be.labil.rest.domain.dtos.EtudiantDto;
import be.labil.rest.domain.entities.Etudiant;
import be.labil.rest.services.interfaces.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Tag(name = "Etudiant", description = "L'api des étudiants")
@RestController
@RequestMapping("/api/etudiant")
@AllArgsConstructor
public class EtudiantController {
    public final IEtudiantService iEtudiantService;


    @PostMapping(value="/create", produces = "application/json")
    Etudiant create(@RequestBody Etudiant etudiant){
        return iEtudiantService.insert(etudiant);
    }

    @Operation(
            summary = "Récupération de la liste des étudiants",
            description = "Retourne la liste de tous les étudiants avec leurs matricules")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Opération réussie")
    })
    @GetMapping(value="/list", produces="application/json")
    Set<EtudiantDto> read(){
        return iEtudiantService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    EtudiantDto update(@PathVariable Long id, @RequestBody EtudiantDto etudiantDto){
        return iEtudiantService.update(id, etudiantDto);
    }

    @DeleteMapping("/delete/{id}")
    Boolean delete(@PathVariable Long id){
        return iEtudiantService.delete(id);
    }
}

