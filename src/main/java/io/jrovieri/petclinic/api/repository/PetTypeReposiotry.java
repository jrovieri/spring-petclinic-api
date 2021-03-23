package io.jrovieri.petclinic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jrovieri.petclinic.api.model.PetType;

public interface PetTypeReposiotry extends JpaRepository<PetType, Long> {

}
