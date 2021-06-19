package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.cvConcretes.Experience;
import kodlamaio.hrms.entities.dtos.ExperienceDto;

@Service
public class ExperienceManager implements ExperienceService {
	private ExperienceDao experienceDao;
	private CvDao cvDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao,CvDao cvDao) {
		super();
		this.experienceDao = experienceDao;
		this.cvDao=cvDao;
	}

	@Override
	public Result add(int cvId,Experience experience) {
		Cv cv = this.cvDao.getOne(cvId);
		Experience exp = new Experience(experience.getId(), cv, experience.getCompanyName(), experience.getPosition(), experience.getStartDate(), experience.getEndDate());
		this.experienceDao.save(exp);
		return new SuccessResult("Deneyim Başarıyla Eklendi");
	}

	@Override
	public Result update(int cvId,Experience experience) {
		Cv cv = this.cvDao.getOne(cvId);
		Experience exp = new Experience(experience.getId(), cv, experience.getCompanyName(), experience.getPosition(), experience.getStartDate(), experience.getEndDate());
		this.experienceDao.save(exp);
		return new SuccessResult("Deneyim başarıyla güncellendi");
	}

	@Override
	public Result delete(int experienceId) {
		Experience deleteExperience = this.experienceDao.findById(experienceId);
		this.experienceDao.delete(deleteExperience);
		return new SuccessResult("Deneyim başarıyla silindi");

	}

	@Override
	public DataResult<List<Experience>> findByOrderByAsc() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findByOrderByAsc(),
				"Başarıyla Listelendi");
	}

	@Override
	public DataResult<List<Experience>> findByCvIdOrderByAsc(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findByCvIdOrderByAsc(id),
				"Cv id ile başarıyla listelendi");
	}

	@Override
	public DataResult<List<Experience>> findByCv_Id(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findByCv_id(id));
	}

}
