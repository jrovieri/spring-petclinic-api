package io.jrovieri.petclinic.api.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public abstract class Person extends BaseEntity {

	private static final long serialVersionUID = 2672290064035012459L;

	@OneToOne
	private PostalAddress address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "telephone")
	private String telephone;
}
