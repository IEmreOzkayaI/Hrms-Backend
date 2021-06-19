package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.Language;
public interface LanguageService {
	Result add(int cvId,Language language);
	Result update(int cvId,Language language);
	Result delete(int languageId);
	
	DataResult<List<Language>> findByCv_Id(int id);
	DataResult<List<Language>> getAll();

}
