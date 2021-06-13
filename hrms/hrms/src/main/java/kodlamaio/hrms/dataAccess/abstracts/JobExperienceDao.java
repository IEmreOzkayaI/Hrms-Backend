package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.cvConcretes.JobExperience;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvExperience;
import kodlamaio.hrms.entities.dtos.ExperienceDto;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
	@Query("from JobExperience order by endDate asc nulls first ")
	List<JobExperience> findByOrderByAsc();

	@Query("from CvExperience where cv.id=:id order by endDate asc nulls first ")
	List<CvExperience> findByCvIdOrderByAsc(@Param(value = "id") int id);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.ExperienceDto"
			+ "(j.companyName,j.position,j.startDate,j.endDate)"
			+ "from CvExperience c "
			+ "Inner Join c.jobExperience j "
			+ "where c.cv.jobSeeker.id=:id ")
	List<ExperienceDto> findByCv_id(@Param(value = "id") int id);

}
