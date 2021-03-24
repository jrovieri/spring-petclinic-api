package io.jrovieri.petclinic.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Owner model.
 * @author jrovieri
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "owners")
public class Owner extends Person {

	private static final long serialVersionUID = -4137342987227981470L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();

	@Builder
	public Owner(Long id, PostalAddress address, String email, String name, 
			String telephone, Set<Pet> pets) {
		super(id, address, email, name, telephone);
		this.pets = pets;
	}
}
