package io.jrovieri.petclinic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jrovieri.petclinic.api.model.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

}
