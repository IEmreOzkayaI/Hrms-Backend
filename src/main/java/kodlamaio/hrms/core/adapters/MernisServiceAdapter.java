package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisValidationService;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class MernisServiceAdapter implements MernisValidationService {

	@Override
	public boolean validate(JobSeeker jobSeeker) {
		// FAKE DOĞRULAMA SİSTEMİDİR.

		return true;
	}

}
