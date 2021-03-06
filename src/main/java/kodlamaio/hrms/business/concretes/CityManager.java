package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir Ekleme Başarılı");
	}

	@Override
	public Result delete(int cityId) {
		City deleteCity = this.cityDao.getById(cityId);
		this.cityDao.delete(deleteCity);
		return new SuccessResult("Şehir Başarıyla Silindi");
	}

	@Override
	public Result update(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir Başarıyla Güncellendi");
	}

	@Override
	public DataResult<List<City>> getAll(){
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Tüm şehirler başarıyla listelendi");
	}
}
