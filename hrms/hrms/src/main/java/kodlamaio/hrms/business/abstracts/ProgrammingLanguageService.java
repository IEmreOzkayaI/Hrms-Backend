package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;

public interface ProgrammingLanguageService {
    Result add(ProgrammingLanguage programmingLanguage);
    
	DataResult<List<ProgrammingLanguageDto>> findByCv_Id(int id);

}
