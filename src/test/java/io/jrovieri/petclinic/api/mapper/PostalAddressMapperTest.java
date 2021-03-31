package io.jrovieri.petclinic.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.jrovieri.petclinic.api.dto.PostalAddressDTO;
import io.jrovieri.petclinic.api.model.PostalAddress;
import org.junit.jupiter.api.Test;

public class PostalAddressMapperTest {

  PostalAddressMapper mapper = PostalAddressMapper.INSTANCE;

  @Test
  void postalAddressToPostalAddressDto() throws Exception {
    PostalAddress model =
        PostalAddress.builder()
            .id(1L)
            .addressCountry("United States")
            .addressLocality("Toledo")
            .addressRegion("Ohio")
            .postalCode("43612")
            .streetAddress("50 Lantern Drive")
            .build();

    PostalAddressDTO dto = mapper.postalAddressToPostalAddressDto(model);

    assertNotNull(dto);
    assertEquals(model.getId(), dto.getId());
    assertEquals(model.getAddressCountry(), dto.getAddressCountry());
    assertEquals(model.getAddressLocality(), dto.getAddressLocality());
    assertEquals(model.getAddressRegion(), dto.getAddressRegion());
    assertEquals(model.getPostalCode(), dto.getPostalCode());
    assertEquals(model.getStreetAddress(), dto.getStreetAddress());
  }

  @Test
  void postalAddressDtoToPostalAddress() throws Exception {
    PostalAddressDTO dto =
        PostalAddressDTO.builder()
            .id(1L)
            .addressCountry("United States")
            .addressLocality("Hinesville")
            .addressRegion("Georgia")
            .postalCode("31313")
            .streetAddress("7326 Bay Meadows Lane")
            .build();

    PostalAddress model = mapper.postalAddressDtoPostalAddress(dto);

    assertNotNull(model);
    assertEquals(dto.getId(), model.getId());
    assertEquals(dto.getAddressCountry(), model.getAddressCountry());
    assertEquals(dto.getAddressLocality(), model.getAddressLocality());
    assertEquals(dto.getAddressRegion(), model.getAddressRegion());
    assertEquals(dto.getPostalCode(), model.getPostalCode());
    assertEquals(dto.getStreetAddress(), model.getStreetAddress());
  }
}
