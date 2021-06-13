package kodlamaio.hrms.core.adapters;

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
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}
	


}
