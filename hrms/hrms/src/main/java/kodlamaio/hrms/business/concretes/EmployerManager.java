package kodlamaio.hrms.business.concretes;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.adapters.EmailValidationAdapter;
import kodlamaio.hrms.core.adapters.SystemPersonnelValidationAdapter;
import kodlamaio.hrms.core.utilities.checkHelpers.EmployerCheckHelper;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
 @Service
 @AllArgsConstructor
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private UserDao userDao;
	private EmailValidationAdapter emailValidationAdapter;
	private SystemPersonnelValidationAdapter systemPersonnelValidationAdapter;

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listeleme Başarılı");
	}
	
	@Override
	public Result add(Employer employer) {
		if(!EmployerCheckHelper.allFieldsAreRequired(employer)) {
			return new ErrorResult("Tüm alanları doldurunuz");
			
		}else if(!isEmailFormatValid(employer)) {
			return new ErrorResult("Email bir şirkete ait değil");
			
		}else if(!employer.getPassword().equals(employer.getRepeatOfPassword())) {
			return new ErrorResult("Şifreler Uyumsuz");
			
		}else if(userDao.findByEmail(employer.getEmail()) != null) {
			return new ErrorResult("Kullanıcı Zaten Kayıtlı");
			
		}else if(!(emailValidationAdapter.isActivat(employer)
				&& systemPersonnelValidationAdapter.isActivated(employer))) {
			return new ErrorResult("Aktivasyon Sağlanamadı");
			
		}else {
			this.employerDao.save(employer);
			return new SuccessResult("Kayıt Başarılı");
		}
	}
	
	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İş veren başarıyla güncellendi");
	}

	@Override
	public Result delete(int id) {
		Employer deleteEmployer = this.employerDao.findById(id);
		this.employerDao.delete(deleteEmployer);
		return new SuccessResult("İş veren başarıyla silindi");
	}
	
	private boolean isEmailFormatValid(Employer employer) {
		String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@"+employer.getWebSite();
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(EMAIL_PATTERN,
		java.util.regex.Pattern.CASE_INSENSITIVE);
		return pattern.matcher(employer.getEmail()).find();	
	}


}
