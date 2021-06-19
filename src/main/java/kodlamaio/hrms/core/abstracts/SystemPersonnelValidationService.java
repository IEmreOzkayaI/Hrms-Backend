package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface SystemPersonnelValidationService {
	boolean isActivated(User user);
}
