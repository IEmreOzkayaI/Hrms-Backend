package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonnelActivationService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonnelActivationDao;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonnelDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;
import kodlamaio.hrms.entities.concretes.SystemPersonnelActivation;

@Service
public class SystemPersonnelActivationManager implements SystemPersonnelActivationService {

	private SystemPersonnelActivationDao systemPersonnelActivationDao;
	private EmployerDao employerDao;
	private SystemPersonnelDao personnelDao;
	
	@Autowired
	public SystemPersonnelActivationManager(SystemPersonnelActivationDao systemPersonnelActivationDao,
			EmployerDao employerDao, SystemPersonnelDao personnelDao) {
		super();
		this.systemPersonnelActivationDao = systemPersonnelActivationDao;
		this.employerDao = employerDao;
		this.personnelDao = personnelDao;
	}

	

	@Override
	public Result activate(boolean activationResult,int employerId,int systemPersonnelId) {
		SystemPersonnelActivation activation;
		Employer emp = this.employerDao.findById(employerId);
		SystemPersonnel sys = this.personnelDao.getById(systemPersonnelId);
		if (activationResult) {
			activation = new SystemPersonnelActivation(0, emp, sys, true);
			this.systemPersonnelActivationDao.save(activation);
			return new SuccessResult("Kullanıcı Onaylandı , Kayıt Başarılı");

		} else {
			return new ErrorResult("Kullanıcı Personel Tarafından Onaylanmadı , Kayıt Başarısız");
		}

	}

	@Override
	public DataResult<List<SystemPersonnelActivation>> getAll() {
		return new SuccessDataResult<List<SystemPersonnelActivation>>(this.systemPersonnelActivationDao.findAll()
				,"Şirket Çalışanı Tarafından Onaylanan Tüm Kullanıcılar Listelendi");
	}

}
