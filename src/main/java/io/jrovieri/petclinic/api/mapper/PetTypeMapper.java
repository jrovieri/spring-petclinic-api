package io.jrovieri.petclinic.api.mapper;

import io.jrovieri.petclinic.api.dto.PetTypeDTO;
import io.jrovieri.petclinic.api.model.PetType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The PetType Mapper
 *
 * @author jrovieri
 */
@Mapper
public interface PetTypeMapper {

  PetTypeMapper INSTANCE = Mappers.getMapper(PetTypeMapper.class);

  PetTypeDTO petTypeToPetTypeDTO(PetType petType);

  PetType petTypeDtoToPetType(PetTypeDTO petTypeDTO);
}
