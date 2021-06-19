package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;

public interface ProgrammingLanguageService {
    Result addToCv(int cvId,ProgrammingLanguage programmingLanguage);
    Result addToDb(ProgrammingLanguage programmingLanguage);
	Result update(int cvId,ProgrammingLanguage programmingLanguage);
	Result delete(int programmingLanguageId);
	
	DataResult<List<ProgrammingLanguageDto>> findByCv_Id(int id);
	DataResult<List<ProgrammingLanguage>> getAll();

}
