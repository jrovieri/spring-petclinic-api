package io.jrovieri.petclinic.api.dto;

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

  private OwnerDTO owner;

  private PetTypeDTO petType;

  private List<VisitDTO> visits;

  @Builder
  public PetDTO(
      Long id,
      LocalDate birthDate,
      String name,
      OwnerDTO owner,
      PetTypeDTO petType,
      List<VisitDTO> visits) {
    this.id = id;
    this.birthDate = birthDate;
    this.name = name;
    this.owner = owner;
    this.petType = petType;
    this.visits = visits;
  }
}
