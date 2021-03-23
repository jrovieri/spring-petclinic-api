package io.jrovieri.petclinic.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
	private LocalDate startDate;
}
