package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.Education;

public interface EducationService {
	Result add(int cvId,Education school);
	Result update(int cvId,Education school);
	Result delete(int id);
	
	DataResult<List<Education>> findAllOrderByAsc();
	DataResult<List<Education>> findByCv_id(int id);



}
