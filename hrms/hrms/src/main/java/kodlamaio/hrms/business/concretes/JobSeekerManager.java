package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.MernisValidationService;
import kodlamaio.hrms.core.adapters.EmailValidationAdapter;
import kodlamaio.hrms.core.utilities.checkHelpers.JobSeekerCheckHelper;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao;
	private UserDao userDao;
	private EmailValidationAdapter emailValidationAdapter;
	private MernisValidationService mernisValidationService;

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Listeleme Başarılı");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if (!JobSeekerCheckHelper.allFieldsAreRequired(jobSeeker)) {
			return new ErrorResult("Tüm alanları doldurunuz");
			
		}else if(!jobSeeker.getPassword().equals(jobSeeker.getRepeatOfPassword())) {
			return new ErrorResult("Şifreler Uyumsuz ");
			
		}else if(!mernisValidationService.validate(jobSeeker)) {
			return new SuccessResult("Doğrulama Başarısız Bilgilerinizi Kontrol Ediniz");
			
		}else if(userDao.findByEmail(jobSeeker.getEmail()) != null 
				|| jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber())!= null) {
			return new ErrorResult("Kullanıcı Zaten Kayıtlı");
			
		}else if(!emailValidationAdapter.isActivat(jobSeeker)) {
			return new ErrorResult("Aktivasyon kodu yanlış veya eksik");
			
		}else {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Kayıt Başarılı");
		}			
	}

}