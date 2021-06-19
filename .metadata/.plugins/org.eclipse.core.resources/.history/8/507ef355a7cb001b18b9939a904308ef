package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrue() {

		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.findJobAdvertisementIsActiveTrue(), "Aktif İlanlar Listelendi");

	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
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
