package io.jrovieri.petclinic.api.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Owner Data Transfer Object.
 *
 * @author jrovieri
 */
@Data
@NoArgsConstructor
public class OwnerDTO {

  private Long id;

  private PostalAddressDTO address;

  private String email;

  private String name;

  private String telephone;

  private List<PetDTO> pets;

  @Builder
  public OwnerDTO(
      Long id,
      PostalAddressDTO address,
      String email,
      String name,
      String telephone,
      List<PetDTO> pets) {
    this.id = id;
    this.address = address;
    this.email = email;
    this.name = name;
    this.telephone = telephone;
    this.pets = pets;
  }
}
