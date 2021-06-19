package kodlamaio.hrms.business.concretes;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	private ExperienceService experienceService;
	private EducationService schoolService;
	private LanguageService languageService;
	private ProgrammingLanguageService programmingLanguageService;
	private JobSeekerDao jobSeekerDao ;
	private JobSeekerService jobSeekerService ;
	private ImageService imageService;


	@Autowired
	public CvManager(CvDao cvDao, ExperienceService experienceService, EducationService schoolService,
			LanguageService languageService, ProgrammingLanguageService programmingLanguageService,JobSeekerDao jobSeekerDao,JobSeekerService jobSeekerService
			,ImageService imageService) {
		super();
		this.cvDao = cvDao;
		this.experienceService = experienceService;
		this.schoolService = schoolService;
		this.languageService = languageService;
		this.programmingLanguageService = programmingLanguageService;
		this.jobSeekerDao = jobSeekerDao;
		this.jobSeekerService = jobSeekerService;
		this.imageService=imageService;
	}
	
	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),"Cvler listelendi");
	}

	@Override
	public DataResult<CvDto> getById(int cvId) {
		CvDto cvDto = this.cvDao.findById(cvId);
		cvDto.setEducations(this.schoolService.findByCv_id(cvId).getData());
		cvDto.setExperiences(this.experienceService.findByCv_Id(cvId).getData());
		cvDto.setLanguages(this.languageService.findByCv_Id(cvId).getData());
		cvDto.setProgrammingLanguages(this.programmingLanguageService.findByCv_Id(cvId).getData());

		return new SuccessDataResult<CvDto>(cvDto, "Data başarıyla listelendi");
	}

	@Override
	public Result add(String github,String linkedin,String biography,int userId) {
		JobSeeker jobSeeker = this.jobSeekerDao.findById(userId);

        Cv cv = new Cv();
        cv.setJobSeeker(jobSeeker);
        cv.setBiography(biography);
        cv.setGithub(github);
        cv.setLinkedin(linkedin);
        
		this.cvDao.save(cv);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public Result delete(int cvId) {
		Cv deleteCv = this.cvDao.getById(cvId);
		this.cvDao.delete(deleteCv);
		return new SuccessResult("Cv Başarıyla Silindi");
	}

	@Override
	public Result update(String github,String linkedin,String biography,int userId) {
		JobSeeker jobSeeker = this.jobSeekerDao.findById(userId);

        Cv cv = new Cv();
        cv.setJobSeeker(jobSeeker);
        cv.setBiography(biography);
        cv.setGithub(github);
        cv.setLinkedin(linkedin);
		
		this.cvDao.save(cv);
		return new SuccessResult("Cv Başarıyla Güncellendi");
	}

}
