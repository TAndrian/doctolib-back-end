package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.Profs;
import sample.data.jpa.service.ProfsDao;



@Controller
@RequestMapping("/api/profs")
public class ProfsController {

	@Autowired
	private ProfsDao profsDao;

	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Profs> addProfs(@RequestBody Profs profs) {
		try {
			profsDao.save(profs);

		} catch (Exception ex) {
			return new ResponseEntity<Profs>(profs, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Profs>(profs, HttpStatus.OK);
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public ResponseEntity<Profs> deleteProfs(@RequestBody Profs profs) {
		try {
			profsDao.delete(profs);

		} catch (Exception ex) {
			return new ResponseEntity<Profs>(profs, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Profs>(profs, HttpStatus.OK);
	}

}
