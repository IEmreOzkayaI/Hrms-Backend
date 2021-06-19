package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.SystemPersonnelActivation;
@Repository
public interface SystemPersonnelActivationDao extends JpaRepository<SystemPersonnelActivation, Integer> {
	List<SystemPersonnelActivation> getByIsActivated(Boolean isActivated);
	SystemPersonnelActivation getById(int Id);

}
