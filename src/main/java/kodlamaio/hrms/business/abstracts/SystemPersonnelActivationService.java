package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.SystemPersonnelActivation;

public interface SystemPersonnelActivationService {
	Result activate(boolean activationResult,int employerId,int systemPersonnelId);
	DataResult<List<SystemPersonnelActivation>> getAll();

}
