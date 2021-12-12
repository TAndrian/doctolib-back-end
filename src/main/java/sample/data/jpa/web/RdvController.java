package sample.data.jpa.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.Patient;
import sample.data.jpa.domain.Profs;
import sample.data.jpa.domain.RDV;
import sample.data.jpa.service.PatientDao;
import sample.data.jpa.service.ProfsDao;
import sample.data.jpa.service.RDVDao;

@Controller
@RequestMapping("/api/rdv")
public class RdvController {

	@Autowired
	private RDVDao rdvDao;

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private ProfsDao profsDao;

	@RequestMapping("/getAll")
	@ResponseBody
	public ResponseEntity<List<RDV>> getAllRdv() {
		List<RDV> rdv = new ArrayList<RDV>();
		try {
			rdv = rdvDao.findAll();
		} catch (Exception ex) {
			return new ResponseEntity<List<RDV>>(rdv, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<RDV>>(rdv, HttpStatus.OK);

	}

	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<RDV> createRDV(@RequestBody RDV appointment) {

		Patient patient = patientDao.findByEmail(appointment.getPatient().getEmail());
		Profs profs = profsDao.findByEmail(appointment.getWorker().getEmail());
		System.err.println("pass par la");

		try {
			if (patient != null && profs != null) {
				List<RDV> rdvList = profs.getRdv();
				rdvList.add(appointment);
				appointment.setPatient(patient);
				appointment.setWorker(profs);
				patient.setRdv(appointment);
				profs.setRdv(rdvList);
       			rdvDao.save(appointment);
       			profsDao.save(profs);
			}
		} catch (Exception ex) {
			return new ResponseEntity<RDV>(appointment, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<RDV>(appointment, HttpStatus.OK);

	}

	
	/*
	 * 
        {
        "id": 3,
        "heure": "10:00",
        "patient": {
            "email": "Ysma@gmail.com",
            "nom": "Arisoa",
            "prenom": "Ysma",
            "password": "123456",
            "rdv": null
        },
        "worker": {
            "email": "SaruK@gmail.com",
            "nom": "K",
            "prenom": "Saru",
            "password": "54321",
            "job": "Dentist"
        },
        "description": "Plaque dentaire consulation",
        "date": "29-11-2021"
    }
    
	 * */
}
