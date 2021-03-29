package io.jrovieri.petclinic.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The PetType Data Transfer Object
 *
 * @author jrovieri
 */
@Data
@NoArgsConstructor
public class PetTypeDTO {

  private Long id;

  private String name;

  @Builder
  public PetTypeDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
