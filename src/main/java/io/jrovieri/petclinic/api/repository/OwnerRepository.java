package io.jrovieri.petclinic.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jrovieri.petclinic.api.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

	List<Owner> findByNameContaining(String name);
}
