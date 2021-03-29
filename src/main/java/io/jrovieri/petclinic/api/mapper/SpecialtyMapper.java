package io.jrovieri.petclinic.api.mapper;

import io.jrovieri.petclinic.api.dto.SpecialtyDTO;
import io.jrovieri.petclinic.api.model.Specialty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The Specialty Mapper
 *
 * @author jrovieri
 */
@Mapper
public interface SpecialtyMapper {

  SpecialtyMapper INSTANCE = Mappers.getMapper(SpecialtyMapper.class);

  SpecialtyDTO specialtyToSpecialtyDto(Specialty specialty);

  Specialty specialtyDtoToSpecialty(SpecialtyDTO specialtyDTO);
}
