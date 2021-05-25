package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserManager implements UserService {

	private UserDao userDao;

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Listeleme Başarılı");
	}
	

}
