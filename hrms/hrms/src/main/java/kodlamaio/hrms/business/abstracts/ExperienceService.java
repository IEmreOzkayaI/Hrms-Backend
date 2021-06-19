package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.JobExperience;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvExperience;
import kodlamaio.hrms.entities.dtos.ExperienceDto;

public interface JobExperienceService {
	Result add(JobExperience jobExperience);

	DataResult<List<JobExperience>> findByOrderByAsc();

	DataResult<List<CvExperience>> findByCvIdOrderByAsc(int id);

	DataResult<List<ExperienceDto>> findByCv_Id(int id);


}
