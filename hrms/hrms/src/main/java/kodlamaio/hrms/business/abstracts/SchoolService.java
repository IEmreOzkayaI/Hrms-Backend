package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.School;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvExperience;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvSchool;
import kodlamaio.hrms.entities.dtos.SchoolDto;

public interface SchoolService {
	Result add(School school);

	DataResult<List<School>> findAllOrderByAsc();

	DataResult<List<CvSchool>> findByCvIdOrderByAsc(int id);
	
	DataResult<List<SchoolDto>> findByCv_id(int id);


}
