package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.Experience;

public interface ExperienceService {
	Result add(int cvId,Experience experience);
	Result update(int cvId,Experience experience);
	Result delete(int jobExperienceId);

	DataResult<List<Experience>> findByOrderByAsc();
	DataResult<List<Experience>> findByCvIdOrderByAsc(int id);
	DataResult<List<Experience>> findByCv_Id(int id);


}
