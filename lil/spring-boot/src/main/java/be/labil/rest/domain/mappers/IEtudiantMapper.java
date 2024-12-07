package be.labil.rest.domain.mappers;

import be.labil.rest.domain.entities.Etudiant;
import be.labil.rest.domain.dtos.EtudiantDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEtudiantMapper extends IGenericMapper<EtudiantDto, Etudiant> {

}