package io.jrovieri.petclinic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jrovieri.petclinic.api.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {

}
