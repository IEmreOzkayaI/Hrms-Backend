package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface EmailValidationService {
	boolean isActivat(User user); 
}
