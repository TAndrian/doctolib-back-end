package sample.data.jpa.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User_type", discriminatorType = DiscriminatorType.STRING)
public class User  implements Serializable{

	

	private static final long serialVersionUID = -7822954998783317026L;

	private String email;

	private String nom;
	
	private String prenom;
	
	private String password;


	
	public User() {
		
	}

	public User(String email) { 
	    this.email = email;
	  }
	  
	  public User(String pname, String name) {
	    this.prenom = pname;
	    this.nom = name;
	  }

	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String pname) {
		this.prenom = pname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}