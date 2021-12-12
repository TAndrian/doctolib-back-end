package sample.data.jpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Patient" )
@DiscriminatorValue("Patient")
public class Patient extends User {

	private static final long serialVersionUID = -5413206127599564367L;
	/**
	 * 
	 */
	private RDV rdv;
	
	public Patient() {
		
	}
	
	

	@OneToOne(mappedBy = "patient")
	public RDV getRdv() {
		return rdv;
	}

	@JsonIgnoreProperties(value = {"patient"})
	public void setRdv(RDV rdv) {
		this.rdv = rdv;
	}

}
