package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.CvProgrammingLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.cvConcretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvProgrammingLanguage;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

    private ProgrammingLanguageDao programmingLanguageDao;
    private CvDao cvDao;
    private CvProgrammingLanguageDao cvProgrammingLanguageDao ; 

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao,CvDao cvDao,CvProgrammingLanguageDao cvProgrammingLanguageDao) {
        this.programmingLanguageDao = programmingLanguageDao;
        this.cvDao=cvDao;
        this.cvProgrammingLanguageDao = cvProgrammingLanguageDao;
    }

    @Override
    public Result addToCv(int cvId,ProgrammingLanguage programmingLanguage) {
    	Cv cv = this.cvDao.getById(cvId);
    	CvProgrammingLanguage cvProgrammingLanguage = new CvProgrammingLanguage(0,cv,programmingLanguage); 
    	if(this.programmingLanguageDao.findById(programmingLanguage.getId()) == null) {
    		this.programmingLanguageDao.save(programmingLanguage);
    	}
    		

        this.cvProgrammingLanguageDao.save(cvProgrammingLanguage);
        return new SuccessResult("Programlama dili Cv ye başarıyla eklendi!");
    }
    
	@Override
	public Result update(int cvId,ProgrammingLanguage programmingLanguage) {
		Cv cv = this.cvDao.getById(cvId);
    	CvProgrammingLanguage cvProgrammingLanguage = new CvProgrammingLanguage(0,cv,programmingLanguage);    	
        this.cvProgrammingLanguageDao.save(cvProgrammingLanguage);
		return new SuccessResult("Programlama dili başarıyla güncellendi");
	}

	@Override
	public Result delete(int programmingLanguageId) {
		ProgrammingLanguage deleteProgrammingLanguage=this.programmingLanguageDao.findById(programmingLanguageId);
		CvProgrammingLanguage deleteCvProgrammingLanguage = this.cvProgrammingLanguageDao.getOne(programmingLanguageId);
		this.programmingLanguageDao.delete(deleteProgrammingLanguage);
		this.cvProgrammingLanguageDao.delete(deleteCvProgrammingLanguage);

		return new SuccessResult("Programlama dili başarıyla silindi");

	}

	@Override
	public DataResult<List<ProgrammingLanguageDto>> findByCv_Id(int id) {
		return new SuccessDataResult<List<ProgrammingLanguageDto>>(this.programmingLanguageDao.findByCv_id(id));
	}

	@Override
	public DataResult<List<ProgrammingLanguage>> getAll() {
		return new SuccessDataResult<List<ProgrammingLanguage>>(this.programmingLanguageDao.findAll());
	}

	@Override
	public Result addToDb(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguageDao.save(programmingLanguage);
		return new SuccessResult("Yeni dil başarıyla eklendi");
	}
}
