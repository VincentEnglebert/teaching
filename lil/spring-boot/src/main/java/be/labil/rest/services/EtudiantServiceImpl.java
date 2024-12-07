package be.labil.rest.services;

import be.labil.rest.domain.dtos.EtudiantDto;
import be.labil.rest.domain.entities.Etudiant;
import be.labil.rest.domain.mappers.IEtudiantMapper;
import be.labil.rest.repositories.interfaces.IEtudiantRepository;
import be.labil.rest.services.interfaces.IEtudiantService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private final IEtudiantRepository iEtudiantRepository;
    private final IEtudiantMapper iEtudiantMapper;


    @Override
    public Etudiant insert(Etudiant etudiant) {
        return iEtudiantRepository.save(etudiant);
    }

    @Override
    public Set<EtudiantDto> list() {
        Set<Etudiant> etudiantSet = new LinkedHashSet<>();
        iEtudiantRepository.findAll().iterator().forEachRemaining(etudiantSet::add);
        return iEtudiantMapper.toDto(etudiantSet);
    }

    @Override
    public EtudiantDto update(Long id, EtudiantDto etudiantDto) {
        return iEtudiantRepository.findById(id)
            .map(e -> {
                e.setNom(etudiantDto.getNom());
                e.setPrenom(etudiantDto.getPrenom());
                e.setMatricule(etudiantDto.getMatricule());
                // Sauvegarder l'entité mise à jour
                Etudiant updatedEtudiant = iEtudiantRepository.save(e);

                log.warn("Mise à jour de l'étudiant {} effectué avec succès", etudiantDto.getMatricule());

                // Convertir l'entité mise à jour en DTO et retourner
                return iEtudiantMapper.toDto(updatedEtudiant);
            }).orElseThrow(()-> new RuntimeException("Etudiant inconnu"));
    }

    @Override
    public Boolean delete(Long id) {
        iEtudiantRepository.deleteById(id);
        return true;
    }
}

