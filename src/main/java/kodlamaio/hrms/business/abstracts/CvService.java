package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CvService {
	Result add(String github,String linkedin,String biography,int userId);
	Result delete(int cvId);
	Result update(String github,String linkedin,String biography,int userId);

	DataResult<CvDto> getById( int cvId);
	DataResult<List<Cv>> getAll(); 
}

