package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	DataResult<List<SystemPersonnel>> getAll();
}
