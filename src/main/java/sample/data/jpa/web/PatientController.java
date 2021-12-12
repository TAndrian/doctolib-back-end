package sample.data.jpa.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.Patient;
import sample.data.jpa.service.PatientDao;



@Controller
@RequestMapping("/api/patient")

public class PatientController {


	@RequestMapping("/getAll")
	@ResponseBody
	public ResponseEntity<List<Patient>> getAllPatient() {
		List<Patient> listPatient = new ArrayList<Patient>();
		try {
			listPatient = patientDao.findAll();

		} catch (Exception ex) {
			return new ResponseEntity<List<Patient>>(listPatient, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Patient>>(listPatient, HttpStatus.OK);

	}
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		try {
			patientDao.save(patient);
		} catch (Exception ex) {
			return new ResponseEntity<Patient>(patient, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);

	}

	
	

	/**
	 * GET /delete --> Delete the Patient having the passed email.
	 */
	@RequestMapping("/delete/{email}")
	@ResponseBody
	public String delete(@PathVariable("email") String email) {
		try {
			patientDao.delete(patientDao.findByEmail(email));
		} catch (Exception ex) {
			return "Error deleting the Patient:" + ex.toString();
		}
		return "Patient succesfully deleted!";
	}

	/**
	 * GET /get-by-email --> Return the id for the Patient having the passed email.
	 */
	@RequestMapping("/get-by-email/{email}")
	@ResponseBody
	public String getByEmail(@PathVariable("email") String email) {
		String patientFullName = "";
		try {
			Patient Patient = patientDao.findByEmail(email);
			patientFullName = String.valueOf(Patient.getNom()) + String.valueOf(Patient.getPrenom());
		} catch (Exception ex) {
			return "Patient not found";
		}
		return "The Patient id is: " + patientFullName;
	}

	/**
	 * GET /update --> Update the email and the name for the Patient in the database
	 * having the passed id.
	 */
	@RequestMapping(value = "/update/{email}/{name}/{pname}/{password}", method = RequestMethod.PATCH)
	@ResponseBody
	public String updatePatient(@PathVariable("email") String email, @PathVariable("name") String name,
			@PathVariable("pname") String pname, @PathVariable("password") String passwrod) {
		try {
			Patient Patient = patientDao.findByEmail(email);
			Patient.setNom(name);
			Patient.setPrenom(pname);
			Patient.setPassword(passwrod);

			patientDao.save(Patient);
		} catch (Exception ex) {
			return "Error updating the Patient: " + ex.toString();
		}
		return "Patient succesfully updated!";
	}

	

	// Private fields

	@Autowired
	private PatientDao patientDao;

}
