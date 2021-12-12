package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.User;

@Transactional
public interface UserDao extends JpaRepository<User, String>{
	
	public User findByEmail(String email);

	

}
