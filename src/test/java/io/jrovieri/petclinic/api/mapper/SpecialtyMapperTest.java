package io.jrovieri.petclinic.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.jrovieri.petclinic.api.dto.SpecialtyDTO;
import io.jrovieri.petclinic.api.model.Specialty;
import org.junit.jupiter.api.Test;

public class SpecialtyMapperTest {

  SpecialtyMapper mapper = SpecialtyMapper.INSTANCE;

  @Test
  void specialtyToSpecialtyDto() throws Exception {
    Specialty model =
        Specialty.builder().id(1L).name("Dentistry").description("The Dentistry Specialty").build();

    SpecialtyDTO dto = mapper.specialtyToSpecialtyDto(model);

    assertNotNull(dto);
    assertEquals(model.getId(), dto.getId());
    assertEquals(model.getName(), dto.getName());
    assertEquals(model.getDescription(), dto.getDescription());
  }

  @Test
  void specialtyDtoToSpecialty() throws Exception {
    SpecialtyDTO dto =
        SpecialtyDTO.builder().id(1L).name("Surgery").description("The Surgery Specialty").build();

    Specialty model = mapper.specialtyDtoToSpecialty(dto);

    assertNotNull(model);
    assertEquals(dto.getId(), model.getId());
    assertEquals(dto.getName(), model.getName());
    assertEquals(dto.getDescription(), model.getDescription());
  }
}
