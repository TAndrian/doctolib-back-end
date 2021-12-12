package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.RDV;




@Transactional
public interface RDVDao extends JpaRepository<RDV, Integer> {
	

}