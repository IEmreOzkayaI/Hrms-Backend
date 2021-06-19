package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.cvConcretes.JobExperience;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvExperience;
import kodlamaio.hrms.entities.dtos.ExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService {
	private JobExperienceDao jobExperienceDao;
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}
	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Deneyim Başarıyla Eklendi");
	}
	@Override
	public DataResult<List<JobExperience>> findByOrderByAsc() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findByOrderByAsc(),"Başarıyla Listelendi");
	}
	@Override
	public DataResult<List<CvExperience>> findByCvIdOrderByAsc(int id) {
		return new SuccessDataResult<List<CvExperience>>(this.jobExperienceDao.findByCvIdOrderByAsc(id),"Cv id ile başarıyla listelendi");
	}
	@Override
	public DataResult<List<ExperienceDto>> findByCv_Id(int id) {
		return new SuccessDataResult<List<ExperienceDto>>(this.jobExperienceDao.findByCv_id(id));
	}
	
	
	
}