package be.labil.rest.services.interfaces;

import be.labil.rest.domain.dtos.EtudiantDto;
import be.labil.rest.domain.entities.Etudiant;

import java.util.Set;

public interface IEtudiantService {

    Etudiant insert(Etudiant etudiant);

    Set<EtudiantDto> list();

    EtudiantDto update(Long id, EtudiantDto etudiantDto);

    Boolean delete(Long id);
}