package io.jrovieri.petclinic.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Postal Address model.
 * @author jrovieri
 *
 */
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

	@Builder
	public PostalAddress(Long id, String addressCountry, String addressLocality, 
			String addressRegion, String postalCode, String streetAddress) {
		super(id);
		this.addressCountry = addressCountry;
		this.addressLocality = addressLocality;
		this.addressRegion = addressRegion;
		this.postalCode = postalCode;
		this.streetAddress = streetAddress;
	}
}
