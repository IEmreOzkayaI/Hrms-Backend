package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.cvConcretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;
	private CvDao cvDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao,CvDao cvDao) {
		super();
		this.languageDao = languageDao;
		this.cvDao=cvDao;
	}

	@Override
	public Result add(int cvId,Language language) {
		Cv cv = this.cvDao.getById(cvId);
		Language lang = new Language(language.getId(), cv, language.getLanguage(), language.getLevel());
		this.languageDao.save(lang);
		return new SuccessResult("Dil Ekleme İşlemi Başarılı");
	}

	@Override
	public Result update(int cvId,Language language) {
		Cv cv = this.cvDao.getById(cvId);
		Language lang = new Language(language.getId(), cv, language.getLanguage(), language.getLevel());
		this.languageDao.save(lang);
		return new SuccessResult("Dil başarıyla güncellendi");
	}

	@Override
	public Result delete(int languageId) {
		Language deleteLanguage = this.languageDao.findById(languageId);
		this.languageDao.delete(deleteLanguage);
		return new SuccessResult("Dil başarıyla silindi");

	}

	@Override
	public DataResult<List<Language>> findByCv_Id(int id) {
		return new SuccessDataResult<List<Language>>(this.languageDao.findByCv_id(id));
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Tüm diller listelendi");
	}

}
