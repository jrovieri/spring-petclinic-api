package io.jrovieri.petclinic.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Visit model.
 * @author jrovieri
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
	
	private static final long serialVersionUID = 1815547421037387142L;

	@Column(name = "description")
	private String description;
	
	@ManyToOne
	private Pet pet;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Builder
	public Visit(Long id, String description, Pet pet, LocalDateTime startDate) {
		super(id);
		this.description = description;
		this.pet = pet;
		this.startDate = startDate;
	}
}
