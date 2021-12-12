package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.Profs;


@Transactional
public interface ProfsDao extends JpaRepository<Profs, String> {
	
	public Profs findByEmail(String email);

}
