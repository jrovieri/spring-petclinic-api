package io.jrovieri.petclinic.api.services;

import io.jrovieri.petclinic.api.dto.OwnerDTO;
import java.util.List;

/**
 * The Owner Service interface
 *
 * @author jrovieri
 */
public interface OwnerService extends CrudService<OwnerDTO, Long> {

  List<OwnerDTO> findByNameContaining(String name);
}
