package io.jrovieri.petclinic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jrovieri.petclinic.api.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
