package io.jrovieri.petclinic.api.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Vet Data Transfer Object
 *
 * @author jrovieri
 */
@Data
@NoArgsConstructor
public class VetDTO {

  private Long id;

  private PostalAddressDTO address;

  private String email;

  private String name;

  private String telephone;

  private List<SpecialtyDTO> specialties;

  @Builder
  public VetDTO(
      Long id,
      PostalAddressDTO address,
      String email,
      String name,
      String telephone,
      List<SpecialtyDTO> specialties) {
    this.id = id;
    this.address = address;
    this.email = email;
    this.name = name;
    this.telephone = telephone;
    this.specialties = specialties;
  }
}
