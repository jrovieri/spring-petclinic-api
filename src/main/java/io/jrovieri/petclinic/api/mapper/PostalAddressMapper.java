package io.jrovieri.petclinic.api.mapper;

import io.jrovieri.petclinic.api.dto.PostalAddressDTO;
import io.jrovieri.petclinic.api.model.PostalAddress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The PostalAddress Mapper
 *
 * @author jrovieri
 */
@Mapper
public interface PostalAddressMapper {

  PostalAddressMapper INSTANCE = Mappers.getMapper(PostalAddressMapper.class);

  PostalAddressDTO postalAddressToPostalAddressDto(PostalAddress postalAddress);

  PostalAddress postalAddressDtoPostalAddress(PostalAddressDTO postalAddressDTO);
}
