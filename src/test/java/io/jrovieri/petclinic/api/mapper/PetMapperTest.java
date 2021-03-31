package io.jrovieri.petclinic.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.jrovieri.petclinic.api.dto.OwnerDTO;
import io.jrovieri.petclinic.api.dto.PetDTO;
import io.jrovieri.petclinic.api.dto.PetTypeDTO;
import io.jrovieri.petclinic.api.dto.VisitDTO;
import io.jrovieri.petclinic.api.model.Owner;
import io.jrovieri.petclinic.api.model.Pet;
import io.jrovieri.petclinic.api.model.PetType;
import io.jrovieri.petclinic.api.model.Visit;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class PetMapperTest {

  PetMapper mapper = PetMapper.INSTANCE;

  @Test
  void petToPetDto() throws Exception {
    Owner owner = Owner.builder().id(1L).build();
    PetType petType = PetType.builder().id(1L).build();

    Visit v0 = Visit.builder().id(1L).build();
    Visit v1 = Visit.builder().id(2L).build();
    Set<Visit> visits = new HashSet<>(Arrays.asList(v0, v1));

    Pet model =
        Pet.builder()
            .id(1L)
            .birthDate(LocalDate.parse("2020-01-01"))
            .name("Flik")
            .owner(owner)
            .petType(petType)
            .visits(visits)
            .build();

    PetDTO dto = mapper.petToPetDto(model);

    assertNotNull(dto);
    assertNotNull(dto.getOwner());
    assertNotNull(dto.getPetType());
    assertNotNull(dto.getVisits());

    assertEquals(model.getId(), dto.getId());
    assertEquals(model.getBirthDate(), dto.getBirthDate());
    assertEquals(model.getName(), dto.getName());
  }

  @Test
  void petDtoToPet() throws Exception {
    OwnerDTO owner = OwnerDTO.builder().id(1L).build();
    PetTypeDTO petType = PetTypeDTO.builder().id(1L).build();

    VisitDTO v0 = VisitDTO.builder().id(1L).build();
    VisitDTO v1 = VisitDTO.builder().id(2L).build();
    List<VisitDTO> visits = Arrays.asList(v0, v1);

    PetDTO dto =
        PetDTO.builder()
            .id(1L)
            .birthDate(LocalDate.parse("2020-01-01"))
            .name("Flik")
            .owner(owner)
            .petType(petType)
            .visits(visits)
            .build();

    Pet model = mapper.petDtotoPet(dto);

    assertNotNull(model);
    assertNotNull(model.getOwner());
    assertNotNull(model.getPetType());
    assertNotNull(model.getVisits());

    assertEquals(dto.getId(), model.getId());
    assertEquals(dto.getBirthDate(), model.getBirthDate());
    assertEquals(dto.getName(), model.getName());
  }
}
