package io.jrovieri.petclinic.api.repository;

import io.jrovieri.petclinic.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Pet Repository
 *
 * @author jrovieri
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {}
