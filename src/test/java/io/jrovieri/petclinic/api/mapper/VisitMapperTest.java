package io.jrovieri.petclinic.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.jrovieri.petclinic.api.dto.PetDTO;
import io.jrovieri.petclinic.api.dto.VisitDTO;
import io.jrovieri.petclinic.api.model.Pet;
import io.jrovieri.petclinic.api.model.Visit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

public class VisitMapperTest {

  VisitMapper mapper = VisitMapper.INSTANCE;

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  @Test
  void visitToVisitDto() throws Exception {
    Pet pet = Pet.builder().id(1L).build();

    Visit model =
        Visit.builder()
            .id(1L)
            .description("Rex Visit")
            .startDate(LocalDateTime.parse("2020-02-02 14:30", formatter))
            .pet(pet)
            .build();

    VisitDTO dto = mapper.visitToVisitDto(model);

    assertNotNull(dto);
    assertNotNull(dto.getPet());

    assertEquals(model.getId(), dto.getId());
    assertEquals(model.getDescription(), dto.getDescription());
    assertEquals(model.getStartDate(), dto.getStartDate());
  }

  @Test
  void visitDtoToVisit() throws Exception {
    PetDTO pet = PetDTO.builder().id(1L).build();

    VisitDTO dto =
        VisitDTO.builder()
            .id(1L)
            .description("Mimi Visit")
            .startDate(LocalDateTime.parse("2019-03-05 17:30", formatter))
            .pet(pet)
            .build();

    Visit model = mapper.visitDtoToVisit(dto);

    assertNotNull(model);
    assertNotNull(model.getPet());

    assertEquals(dto.getId(), model.getId());
    assertEquals(dto.getDescription(), model.getDescription());
    assertEquals(dto.getStartDate(), model.getStartDate());
  }
}
