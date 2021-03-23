package io.jrovieri.petclinic.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "postal_addresses")
public class PostalAddress extends BaseEntity {

	private static final long serialVersionUID = 7647033052756579615L;

	@Column(name = "country")
	private String addressCountry;
	
	@Column(name = "locality")
	private String addressLocality;
	
	@Column(name = "region")
	private String addressRegion;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "address")
	private String streetAddress;
}
