package io.jrovieri.petclinic.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jrovieri.petclinic.api.model.Vet;

public interface VetRepository extends JpaRepository<Vet, Long> {

}
