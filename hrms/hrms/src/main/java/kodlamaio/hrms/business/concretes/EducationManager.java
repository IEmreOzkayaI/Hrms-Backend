package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.cvConcretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	private CvDao cvDao;

	@Autowired
	public EducationManager(EducationDao educationDao,CvDao cvDao) {
		super();
		this.educationDao = educationDao;
		this.cvDao = cvDao;
	}

	@Override
	public Result add(int cvId,Education education) {
		Cv cv = this.cvDao.getOne(cvId);
		Education edu = new Education(education.getId(), cv, education.getName(), education.getDepartment(), education.getStartDate(),education.getEndDate());
		this.educationDao.save(edu);
		return new SuccessResult("Okul Başarıyla Eklendi");

	}

	@Override
	public Result delete(int id) {
		Education deleteSchool = this.educationDao.getById(id);
		this.educationDao.delete(deleteSchool);
		return new SuccessResult("Okul Başarıyla Silindi");
	}

	@Override
	public Result update(int cvId,Education education) {
		Cv cv = this.cvDao.getOne(cvId);
		Education edu = new Education(education.getId(), cv, education.getName(), education.getDepartment(), education.getStartDate(), education.getEndDate());
		this.educationDao.save(edu);
		return new SuccessResult("Okul Başarıyla Güncellendi");
	}

	@Override
	public DataResult<List<Education>> findAllOrderByAsc() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllOrderByAsc());
	}

	@Override
	public DataResult<List<Education>> findByCv_id(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.findByCv_id(id));
	}

}
