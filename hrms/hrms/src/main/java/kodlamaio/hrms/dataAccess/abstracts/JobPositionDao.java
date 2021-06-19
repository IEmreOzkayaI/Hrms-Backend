package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPosition;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	JobPosition findById(int id);

	JobPosition findByPositionName(String positionName);
}