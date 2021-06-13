package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.cvConcretes.Image;

public interface ImageService {
	Result add(Image image,MultipartFile imageFile);
	Result update(Image image);
	Result delete(Image	image);
	DataResult<Image> getById(int id);	
	DataResult<List<Image>> getAll();
	DataResult<Image> getByCvId(int id);
}
