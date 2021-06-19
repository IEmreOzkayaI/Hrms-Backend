package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;

public interface CityService {
	Result add(City city);
	Result delete(int cityId);
	Result update(City city);

	DataResult<List<City>> getAll();
} 
