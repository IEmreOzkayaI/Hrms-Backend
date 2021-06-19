package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.EmailActivation;
@Repository
public interface EmailActivationDao extends JpaRepository<EmailActivation, Integer>{
	EmailActivation getById(int Id);
	EmailActivation getByActivationCode(String email);
	List<EmailActivation> getByIsActivated(Boolean isActivated);
}
