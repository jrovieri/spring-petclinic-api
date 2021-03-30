package io.jrovieri.petclinic.api.repository;

import io.jrovieri.petclinic.api.model.Owner;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Owner Repository
 *
 * @author jrovieri
 */
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

  List<Owner> findByNameContaining(String name);
}
