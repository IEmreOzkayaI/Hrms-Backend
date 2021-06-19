package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmailActivation;
import kodlamaio.hrms.entities.concretes.User;

public interface EmailActivationService {
	Result activate(String activationCode , User user);
	DataResult<EmailActivation> get(int Id);
	DataResult<List<EmailActivation>> getAll();
}
