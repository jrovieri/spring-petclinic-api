package io.jrovieri.petclinic.api.mapper;

import io.jrovieri.petclinic.api.dto.PetDTO;
import io.jrovieri.petclinic.api.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The Pet Mapper
 *
 * @author jrovieri
 */
@Mapper
public interface PetMapper {

  PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

  PetDTO petToPetDto(Pet pet);

  Pet petDtotoPet(PetDTO petDTO);
}
