package io.jrovieri.petclinic.api.dto;

import io.jrovieri.petclinic.api.model.Owner;
import io.jrovieri.petclinic.api.model.PetType;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Pet Data Transfer Object
 *
 * @author jrovieri
 */
@Data
@NoArgsConstructor
public class PetDTO {

  private Long id;

  private LocalDate birthDate;

  private String name;

  private Owner owner;

  private PetType petType;

  private List<VisitDTO> visits;

  @Builder
  public PetDTO(
      Long id,
      LocalDate birthDate,
      String name,
      Owner owner,
      PetType petType,
      List<VisitDTO> visits) {
    this.id = id;
    this.birthDate = birthDate;
    this.name = name;
    this.owner = owner;
    this.petType = petType;
    this.visits = visits;
  }
}
