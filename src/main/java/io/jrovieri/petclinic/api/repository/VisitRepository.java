package io.jrovieri.petclinic.api.repository;

import io.jrovieri.petclinic.api.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Visit Repository
 *
 * @author jrovieri
 */
@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {}
