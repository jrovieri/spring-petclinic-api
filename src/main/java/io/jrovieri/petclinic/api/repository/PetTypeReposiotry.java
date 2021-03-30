package io.jrovieri.petclinic.api.repository;

import io.jrovieri.petclinic.api.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The PetType Repository
 *
 * @author jrovieri
 */
@Repository
public interface PetTypeReposiotry extends JpaRepository<PetType, Long> {}
