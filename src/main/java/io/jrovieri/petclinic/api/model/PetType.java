package io.jrovieri.petclinic.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Pet Type model.
 * @author jrovieri
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity {
	
	private static final long serialVersionUID = 1213013390191714061L;

	@Column(name = "name")
	private String name;
	
	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}
}
