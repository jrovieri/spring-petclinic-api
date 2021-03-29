package io.jrovieri.petclinic.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The PostalAddress Data Transfer Object
 *
 * @author jrovieri
 */
@Data
@NoArgsConstructor
public class PostalAddressDTO {

  private Long id;

  private String addressCountry;

  private String addressLocality;

  private String addressRegion;

  private String postalCode;

  private String streetAddress;

  @Builder
  public PostalAddressDTO(
      Long id,
      String addressCountry,
      String addressLocality,
      String addressRegion,
      String postalCode,
      String streetAddress) {
    this.id = id;
    this.addressCountry = addressCountry;
    this.addressLocality = addressLocality;
    this.addressRegion = addressRegion;
    this.postalCode = postalCode;
    this.streetAddress = streetAddress;
  }
}
