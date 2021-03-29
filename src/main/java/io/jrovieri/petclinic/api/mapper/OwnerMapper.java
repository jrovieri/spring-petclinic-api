package io.jrovieri.petclinic.api.mapper;

import io.jrovieri.petclinic.api.dto.OwnerDTO;
import io.jrovieri.petclinic.api.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The Owner Mapper
 *
 * @author jrovieri
 */
@Mapper
public interface OwnerMapper {

  OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

  OwnerDTO ownerToOwnerDto(Owner owner);

  Owner ownerDtoToOwner(OwnerDTO ownerDTO);
}
