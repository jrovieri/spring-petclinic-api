package io.jrovieri.petclinic.api.repository;

import io.jrovieri.petclinic.api.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Vet Repository
 *
 * @author jrovieri
 */
@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {}
