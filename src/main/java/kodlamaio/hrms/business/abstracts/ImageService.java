package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.Image;

public interface ImageService {
	Result add(int cvId, String imageFile);

	Result update(int cvId, String imageFile);

	Result delete(int imageId);

	DataResult<Image> getById(int id);

	DataResult<List<Image>> getAll();

	DataResult<Image> getByCvId(int id);
}
