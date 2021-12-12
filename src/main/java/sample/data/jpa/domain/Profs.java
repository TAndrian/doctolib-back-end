package sample.data.jpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Profesionnals")
@DiscriminatorValue("Profesionnals")
public class Profs extends User {


	private static final long serialVersionUID = -6278337949605163019L;
	
	private String job;

	public Profs() {
	}
	
	public Profs(String email, String job) {
		super(email);
		this.job = job;	
	}


	// private String description;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

//		public String getDescription() {
//			return description;
//		}
//
//		public void setDescription(String description) {
//			this.description = description;
//		}

	private List<RDV> rdv = new ArrayList<RDV>();

	@OneToMany(mappedBy = "worker", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties(value = {"profs"})
	public List<RDV> getRdv() {
		return rdv;
	}

	public void setRdv(List<RDV> rdvs) {
		this.rdv = rdvs;
	}

}
