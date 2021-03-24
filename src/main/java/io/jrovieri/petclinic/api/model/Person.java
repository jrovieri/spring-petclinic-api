package io.jrovieri.petclinic.api.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Person model.
 * @author jrovieri
 *
 */
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
	
	public Person(Long id, PostalAddress address, String email, String name, 
			String telephone) {
		super(id);
		this.address = address;
		this.email = email;
		this.name = name;
		this.telephone = telephone;
	}
}
