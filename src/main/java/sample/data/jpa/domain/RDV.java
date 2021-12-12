package sample.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class RDV {

	private Integer id;

	private String Date;
	
	private String heure;

	private Patient patient;

	private Profs worker;

	private String description;
	
	public RDV() {
		
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
	

	
	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	@OneToOne
	@JsonIgnoreProperties(value = {"rdv"})
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne
	@JsonIgnoreProperties(value = {"rdv"})
	public Profs getWorker() {
		return worker;
	}

	public void setWorker(Profs worker) {
		this.worker = worker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
