package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobSeeker;
@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	JobSeeker findById(int id);
	JobSeeker findByCv_id(int id);
	
	JobSeeker findByIdentityNumber(String identityNumber);
}
