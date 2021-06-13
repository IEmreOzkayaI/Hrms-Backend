package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.ErrorDataResult;
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
	public Result add(Image image, MultipartFile imageFile) {
		Map<String, String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		for (Cv c : cvDao.findAll()) {
			if (c.getId() == image.getCv().getId()) {
				image.setImageUrl(uploadImage.get("url"));
				this.imageDao.save(image);
				return new SuccessResult("Fotoğraf eklendi!");
			} 
		}
		return new ErrorResult("Böyle bir cv mevcut değil fotoğraf eklenemedi!");
		

	}

	@Override
	public Result update(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("Fotoğraf güncellendi!");
	}

	@Override
	public Result delete(Image image) {
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