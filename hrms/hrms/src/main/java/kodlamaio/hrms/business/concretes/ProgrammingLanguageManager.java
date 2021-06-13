package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.cvConcretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

    private ProgrammingLanguageDao programmingLanguageDao;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
        this.programmingLanguageDao = programmingLanguageDao;
    }

    @Override
    public Result add(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguageDao.save(programmingLanguage);
        return new SuccessResult("Programlama dili başarıyla eklendi!");
    }

	@Override
	public DataResult<List<ProgrammingLanguageDto>> findByCv_Id(int id) {
		return new SuccessDataResult<List<ProgrammingLanguageDto>>(this.programmingLanguageDao.findByCv_id(id));
	}
}