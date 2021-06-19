package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	Result add(SystemPersonnel systemPersonnel);
	Result update(SystemPersonnel systemPersonnel);
	Result delete(int id);
	
	DataResult<List<SystemPersonnel>> getAll();
	DataResult<SystemPersonnel> getById(int id);
}
