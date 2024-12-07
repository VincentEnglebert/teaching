package be.labil.rest.domain.dtos;

import be.labil.rest.domain.entities.Etudiant;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Etudiant}
 */
@Value
public class EtudiantDto implements Serializable {
    Long id;
    @NotNull(message = "Ce champ ne doit pas être vide")
    String matricule;
    String nom;
    String prenom;
}