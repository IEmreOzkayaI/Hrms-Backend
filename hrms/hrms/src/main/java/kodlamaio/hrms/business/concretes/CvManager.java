package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.CvDto;
import net.bytebuddy.asm.Advice.This;
@Service
public class CvManager  implements CvService{
	
	private CvDao cvDao;
	private JobExperienceService jobExperienceService;
	private SchoolService schoolService;
	private LanguageService languageService;
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public CvManager(CvDao cvDao, JobExperienceService jobExperienceService, SchoolService schoolService,
			LanguageService languageService, ProgrammingLanguageService programmingLanguageService) {
		super();
		this.cvDao = cvDao;
		this.jobExperienceService = jobExperienceService;
		this.schoolService = schoolService;
		this.languageService = languageService;
		this.programmingLanguageService = programmingLanguageService;
	}

	@Override
	public DataResult<CvDto> getById(int cvId) {
		CvDto cvDto = this.cvDao.findById(cvId);
		cvDto.setSchools(this.schoolService.findByCv_id(cvDto.getJobSeeker()).getData());
		cvDto.setJobExperiences(this.jobExperienceService.findByCv_Id(cvDto.getJobSeeker()).getData());
		cvDto.setLanguages(this.languageService.findByCv_Id(cvDto.getJobSeeker()).getData());
		cvDto.setProgrammingLanguages(this.programmingLanguageService.findByCv_Id(cvDto.getJobSeeker()).getData());
		return new SuccessDataResult<CvDto>(cvDto,"Data başarıyla listelendi");
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());

	}



}