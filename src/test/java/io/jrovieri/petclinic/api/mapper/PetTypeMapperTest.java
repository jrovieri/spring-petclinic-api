package io.jrovieri.petclinic.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.jrovieri.petclinic.api.dto.PetTypeDTO;
import io.jrovieri.petclinic.api.model.PetType;

public class PetTypeMapperTest {

  PetTypeMapper mapper = PetTypeMapper.INSTANCE;

  @Test
  void petTypeToPetTypeDto() throws Exception {
    PetType model = PetType.builder().id(1L).name("Dog").build();

    PetTypeDTO dto = mapper.petTypeToPetTypeDTO(model);

    assertNotNull(dto);
    assertEquals(dto.getId(), model.getId());
    assertEquals(dto.getName(), model.getName());
  }

  @Test
  void petTypeDtoToPetType() throws Exception {
    PetTypeDTO dto = PetTypeDTO.builder().id(1L).name("Cat").build();

    PetType model = mapper.petTypeDtoToPetType(dto);

    assertNotNull(model);
    assertEquals(model.getId(), dto.getId());
    assertEquals(model.getName(), dto.getName());
  }
}
