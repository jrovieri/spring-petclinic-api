package io.jrovieri.petclinic.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
}
