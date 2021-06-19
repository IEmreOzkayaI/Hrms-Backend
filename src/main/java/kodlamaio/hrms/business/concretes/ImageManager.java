package kodlamaio.hrms.business.concretes;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.cvConcretes.Image;

@Service
public class ImageManager implements ImageService {

	private ImageUploadService imageUploadService;
	private ImageDao imageDao;
	private CvDao cvDao;

	@Autowired
	public ImageManager(ImageUploadService imageUploadService, ImageDao imageDao, CvDao cvDao) {
		super();
		this.imageUploadService = imageUploadService;
		this.imageDao = imageDao;
		this.cvDao = cvDao;
	}

	@SuppressWarnings("unchecked")
	@Override	
	public Result add(int cvId, String imageFile) {
		Cv cv = this.cvDao.getById(cvId);
		File file = new File(imageFile);
		String link = imageUploadService.uploadImageFile(file);
		
		Image image = new Image(0, link, cv);
		
		cv.setImage(image);
		
		this.imageDao.save(image);
		this.cvDao.save(cv);
		return new SuccessResult("Resim Başarıyla Eklendi");

	}

	@Override
	public Result update(int cvId, String imageFile) {
		Cv cv = this.cvDao.getById(cvId);
		Image toDelete = this.imageDao.findByCv_id(cvId);
		this.imageDao.delete(toDelete);
		
		File file = new File(imageFile);
		
		String link = imageUploadService.uploadImageFile(file);
		
		Image image = new Image(0, link, cv);
		
		
		this.imageDao.save(image);

		cv.setImage(image);

		this.cvDao.save(cv);
		return new SuccessResult("Resim Başarıyla Eklendi");

	}

	@Override
	public Result delete(int  imageId) {
		Image image = this.imageDao.findById(imageId);
		this.imageDao.delete(image);
		return new SuccessResult("Fotoğraf silindi!");
	}

	@Override
	public DataResult<Image> getById(int id) {
		return new SuccessDataResult<Image>(this.imageDao.findById(id));
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}

	@Override
	public DataResult<Image> getByCvId(int id) {
		return new SuccessDataResult<Image>(this.imageDao.findByCv_id(id));
	}

}
