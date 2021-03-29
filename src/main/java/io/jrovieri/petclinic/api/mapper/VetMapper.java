package io.jrovieri.petclinic.api.mapper;

import io.jrovieri.petclinic.api.dto.VetDTO;
import io.jrovieri.petclinic.api.model.Vet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The Vet Mapper
 *
 * @author jrovieri
 */
@Mapper
public interface VetMapper {

  VetMapper INSTANCE = Mappers.getMapper(VetMapper.class);

  VetDTO vetToVetDto(Vet vet);

  Vet vetDtoToVet(VetDTO vetDTO);
}
