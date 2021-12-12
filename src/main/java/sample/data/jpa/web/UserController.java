package sample.data.jpa.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.User;
import sample.data.jpa.service.UserDao;



@Controller
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/getUser")
	@ResponseBody
	public ResponseEntity<List<User>> getUser() {
		List<User> user = new ArrayList<User>();
		try {
			user = userDao.findAll();

		} catch (Exception ex) {
			return new ResponseEntity<List<User>>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<User> addUser(@RequestBody User user) {
		try {
			userDao.save(user);
		} catch (Exception ex) {
			return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

}
