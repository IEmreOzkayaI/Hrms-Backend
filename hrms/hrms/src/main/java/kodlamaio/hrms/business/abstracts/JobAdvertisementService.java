package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
	Result closeJobAdvertisement(int id);

	DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrue();

	DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrueOrderByReleaseDate();

	DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrueAndEmployer_UserId(int id);
	

}
