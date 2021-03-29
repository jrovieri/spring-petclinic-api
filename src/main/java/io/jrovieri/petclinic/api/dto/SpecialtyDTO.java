package io.jrovieri.petclinic.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Specialty Data Transfer Object
 *
 * @author jrovieri
 */
@Data
@NoArgsConstructor
public class SpecialtyDTO {

  private Long id;

  private String name;

  private String description;

  @Builder
  public SpecialtyDTO(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
}
