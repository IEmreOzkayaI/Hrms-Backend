package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private JobPositionDao jobPositionDao;
	private EmployerDao employerDao;
	private CityDao cityDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, JobPositionDao jobPositionDao,
			EmployerDao employerDao, CityDao cityDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.jobPositionDao = jobPositionDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrue() {

		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.findJobAdvertisementIsActiveTrue(), "Aktif İlanlar Listelendi");

	}

	@Override
	public Result add(int employerId, int jobPositionId,int cityId,JobAdvertisement jobAdvertisement) {
		JobPosition jobPosition = this.jobPositionDao.findById(jobPositionId);
		Employer employer = this.employerDao.findById(employerId);
		City city = this.cityDao.getById(cityId);
		JobAdvertisement advertisement = new JobAdvertisement(0, employer, jobPosition,
				jobAdvertisement.getJobDescription(), city, jobAdvertisement.getMinSalary(),
				jobAdvertisement.getMaxSalary(), jobAdvertisement.getOpenPositions(), jobAdvertisement.getLastDate(),
				jobAdvertisement.isActive(), jobAdvertisement.getReleaseDate());
		this.jobAdvertisementDao.save(advertisement);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public Result update(int employerId, int jobPositionId,int cityId, JobAdvertisement jobAdvertisement) {
		JobPosition jobPosition = this.jobPositionDao.findById(jobPositionId);
		Employer employer = this.employerDao.findById(employerId);
		City city = this.cityDao.getById(cityId);
		JobAdvertisement advertisement = new JobAdvertisement(jobAdvertisement.getId(), employer, jobPosition,
				jobAdvertisement.getJobDescription(), city, jobAdvertisement.getMinSalary(),
				jobAdvertisement.getMaxSalary(), jobAdvertisement.getOpenPositions(), jobAdvertisement.getLastDate(),
				jobAdvertisement.isActive(), jobAdvertisement.getReleaseDate());
		this.jobAdvertisementDao.save(advertisement);
		return new SuccessResult("İş ilanı başarıyla güncellendi");
	}

	@Override
	public Result delete(int jobAdvertisementId) {
		JobAdvertisement deleteJobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisementId);
		this.jobAdvertisementDao.delete(deleteJobAdvertisement);
		return new SuccessResult("İş ilanı başarıyla silindi");

	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrueOrderByReleaseDate() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.findJobAdvertisementIsActiveTrueOrderByReleaseDate(),
				"Aktif İş İlanları Yayınlanma Tarihine Göre Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrueAndEmployer_UserId(int id) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.findJobAdvertisementIsActiveTrueAndEmployer_UserId(id),
				"Bir Şirkete Ait Aktif İş İlanları Listelendi");
	}

	@Override
	public Result closeJobAdvertisement(int id) {
		JobAdvertisement isActive = this.jobAdvertisementDao.findById(id).get();
		isActive.setActive(false);
		this.jobAdvertisementDao.save(isActive);
		return new SuccessResult("İlan kapatıldı.");
	}


}
