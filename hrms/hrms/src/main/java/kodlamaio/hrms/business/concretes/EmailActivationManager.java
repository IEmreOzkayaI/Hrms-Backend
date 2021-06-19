package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailActivationService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmailActivationDao;
import kodlamaio.hrms.entities.concretes.EmailActivation;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmailActivationManager implements EmailActivationService {

	private EmailActivationDao emailActivationDao;

	@Autowired
	public EmailActivationManager(EmailActivationDao emailActivationDao) {
		super();
		this.emailActivationDao = emailActivationDao;
	}

	@Override
	public Result activate(String activationCode, User user) {
		String createdCode = codeCreator();
//		String createdCode = "222";
		EmailActivation em;
		if (createdCode.equals(activationCode)) {
			em = new EmailActivation(0, activationCode, true, user);
			this.emailActivationDao.save(em);
			return new SuccessResult("Email Onaylandı , Kayıt Başarılı");
		} else {
			return new ErrorResult("Doğrulama Kodu Yanlış , Kayıt Başarısız");
		}

	}

	@Override
	public DataResult<EmailActivation> get(int Id) {
		return new SuccessDataResult<EmailActivation>(this.emailActivationDao.getById(Id));
	}

	@Override
	public DataResult<List<EmailActivation>> getAll() {
		return new SuccessDataResult<List<EmailActivation>>(this.emailActivationDao.findAll());
	}

	private String codeCreator() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;
	}

}
