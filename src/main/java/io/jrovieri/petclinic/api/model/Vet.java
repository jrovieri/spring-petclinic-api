package io.jrovieri.petclinic.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Vet model.
 * @author jrovieri
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "vets")
public class Vet extends Person {

	private static final long serialVersionUID = -5191755906744642839L;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties", 
		joinColumns = @JoinColumn(name = "vet_id"),
		inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	private Set<Specialty> specialties = new HashSet<>();

	@Builder
	public Vet(Long id, PostalAddress address, String email, String name, 
			String telephone, Set<Specialty> specialties) {
		super(id, address, email, name, telephone);
		this.specialties = specialties;
	}
}
