package kodlamaio.hrms.core.adapters;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.business.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.dataResults.ErrorDataResult;
import kodlamaio.hrms.core.utilities.dataResults.SuccessDataResult;
@Service
public class CloudinaryServiceAdapter implements ImageUploadService {

private Cloudinary cloudinary;
	
	public CloudinaryServiceAdapter() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","humanresourcesmanagement",
				"api_key", "415694758744252",
				"api_secret","GPfy_q8-SUIT3c-UGGxYOEQ7J40"));
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String uploadImageFile(File imageFile) {
		try {
			Map resultMap = cloudinary.uploader().upload(imageFile, ObjectUtils.emptyMap());
			return (resultMap.get("url").toString());
		} catch (IOException e) {
			
			throw new RuntimeException(e);
			
		}
	}
	
	

}
