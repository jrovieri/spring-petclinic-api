package io.jrovieri.petclinic.api.repository;

import io.jrovieri.petclinic.api.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Specialty Repository
 *
 * @author jrovieri
 */
@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {}
