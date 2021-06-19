package kodlamaio.hrms.core.utilities.checkHelpers;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public class JobSeekerCheckHelper {
	public static boolean allFieldsAreRequired(JobSeeker jobSeeker ){
		if(jobSeeker.getFirstName().isEmpty()
				|| jobSeeker.getLastName().isEmpty()
				|| jobSeeker.getIdentityNumber().isEmpty()
				|| jobSeeker.getEmail().isEmpty()
				|| jobSeeker.getPassword().isEmpty()
				|| jobSeeker.getRepeatOfPassword().isEmpty()) 
        {
            return false;
        }
        return true;
    }
}
