package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.SystemPersonnelValidationService;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class SystemPersonnelValidationAdapter implements SystemPersonnelValidationService {

	@Override
	public boolean isActivated(User user) {
		return true;
	}

}
