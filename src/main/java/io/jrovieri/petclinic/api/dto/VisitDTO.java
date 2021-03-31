package io.jrovieri.petclinic.api.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Visit Data Transfer Object
 *
 * @author jrovieri
 */
@Data
@NoArgsConstructor
public class VisitDTO {

  private Long id;

  private String description;

  private PetDTO pet;

  private LocalDateTime startDate;

  @Builder
  public VisitDTO(Long id, String description, PetDTO pet, LocalDateTime startDate) {
    this.id = id;
    this.description = description;
    this.pet = pet;
    this.startDate = startDate;
  }
}
