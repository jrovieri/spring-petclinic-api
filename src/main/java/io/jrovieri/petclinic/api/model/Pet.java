package io.jrovieri.petclinic.api.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Pet model.
 * @author jrovieri
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	
	private static final long serialVersionUID = 2690496550849377267L;

	@Builder
	public Pet(Long id, LocalDate birthDate, String name, Owner owner, 
			PetType petType, Set<Visit> visits) {
		super(id);
		this.birthDate = birthDate;
		this.name = name;
		this.owner = owner;
		this.petType = petType;
		this.visits = visits;
	}

	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();
}
