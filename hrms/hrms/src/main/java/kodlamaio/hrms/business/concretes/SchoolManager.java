package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.cvConcretes.School;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvSchool;
import kodlamaio.hrms.entities.dtos.SchoolDto;

@Service
public class SchoolManager implements SchoolService {
	
	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul Başarıyla Eklendi");

	}

	@Override
	public DataResult<List<School>> findAllOrderByAsc() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllOrderByAsc());
	}

	@Override
	public DataResult<List<CvSchool>> findByCvIdOrderByAsc(int id) {
		return new SuccessDataResult<List<CvSchool>>(this.schoolDao.findByCvIdOrderByAsc(id));
	}

	@Override
	public DataResult<List<SchoolDto>> findByCv_id(int id) {
		return new SuccessDataResult<List<SchoolDto>>(this.schoolDao.findByCv_id(id));
	}



}
