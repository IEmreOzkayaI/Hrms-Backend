package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;

public interface LanguageService {
	Result add(Language language);
	
	DataResult<List<LanguageDto>> findByCv_Id(int id);

}
