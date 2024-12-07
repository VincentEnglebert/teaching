package be.labil.rest.repositories.interfaces;

import be.labil.rest.domain.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
}
