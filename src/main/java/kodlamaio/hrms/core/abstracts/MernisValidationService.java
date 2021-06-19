package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface MernisValidationService {
	boolean validate(JobSeeker jobSeeker);
}
