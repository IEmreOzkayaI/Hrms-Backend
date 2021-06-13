package kodlamaio.hrms.business.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;

public interface ImageUploadService {
	@SuppressWarnings("rawtypes")
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
