package kodlamaio.hrms.core.utilities.checkHelpers;

import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerCheckHelper {
	public static boolean allFieldsAreRequired(Employer employer ){
		if(employer.getCompanyName().isEmpty()
				|| employer.getWebSite().isEmpty()
				|| employer.getEmail().isEmpty()
				|| employer.getPassword().isEmpty()
				|| employer.getPhoneNumber().isEmpty()
				|| employer.getRepeatOfPassword().isEmpty()) 
        {
            return false;
        }
        return true;
    }
}
