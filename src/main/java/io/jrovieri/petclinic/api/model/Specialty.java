package io.jrovieri.petclinic.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Specialty model.
 * @author jrovieri
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {
	
	private static final long serialVersionUID = -4340224025845447325L;

	@Column(name = "description")
	private String description;
	
	@Column(name = "name")
	private String name;

	@Builder
	public Specialty(Long id, String description, String name) {
		super(id);
		this.description = description;
		this.name = name;
	}
}
